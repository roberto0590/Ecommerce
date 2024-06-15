package com.ecommerce.service.impl;

import com.ecommerce.client.PayFeignClient;
import com.ecommerce.client.ProductFeignClient;
import com.ecommerce.dto.*;
import com.ecommerce.entity.Client;
import com.ecommerce.entity.DetailOrder;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ModeloNotFoundException;

import com.ecommerce.mapper.OrderMapper;
import com.ecommerce.repo.IClientRepo;
import com.ecommerce.repo.IDetailOrderRepo;
import com.ecommerce.repo.IOrderRepo;
import com.ecommerce.service.IDetailOrderService;
import com.ecommerce.service.IOrdersService;
import com.ecommerce.repo.IGenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersServiceImpl extends CRUDImpl<Order, Integer> implements IOrdersService {

	@Autowired
	private IOrderRepo repoOrder;
	@Autowired
	private IDetailOrderRepo repoDetailOrder;
	@Autowired
	private IClientRepo clientRepo;
	@Autowired
	private ProductFeignClient productFeignClient;
	@Autowired
	private PayFeignClient payFeignClient;

	@Autowired
	private IDetailOrderService detailOrderService;

	@Override
	protected IGenericRepo<Order, Integer> getRepo() {
		return repoOrder;
	}

	public List<Order> findByClientes(Integer cliente){
		List<Order> orders= repoOrder.findByClientes(cliente);
		return orders;
	}

	public Sales findOrderByClient(Integer client, String mail){
		Sales sales = new Sales();
		List<Order> orders= repoOrder.findByClientIdOrClientEmail(client,mail);
		List<OrderResultDTO> orderResultDTO = orders.stream().map(order -> OrderMapper.mapper.orderToOrderResultDto(order)).collect(Collectors.toList());
		sales.setOrderDTO(orderResultDTO);
		ClientDTO clientDTO = OrderMapper.mapper.clientToClienDTO(clientRepo.findByClient(client));
		sales.setClientDTO(clientDTO);
		sales.setOrderDTO(orderResultDTO.stream().map(order ->{
			order.setDetailOrderResultDTO(
				repoDetailOrder.findByClientAndOrder(client,order.getId()).
						stream().
						map(detailOrder ->
								OrderMapper.mapper.detailToDetailOrderResultDto(detailOrder)).collect(Collectors.toList())
			);
			order.setPaysDTO(payFeignClient.findByOrderID(order.getId()));
					return order;
				}
		).collect(Collectors.toList())
		);

		return sales;
	}

	public Sales findOrderByDate(String date1, String date2) throws Exception{
		Sales sales = new Sales();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateTime1 = LocalDate.parse(date1, formatter);
		LocalDate dateTime2 = LocalDate.parse(date2, formatter);
		List<Order> orders= repoOrder.findByOrderDate(dateTime1,dateTime2);
		List<OrderResultDTO> orderResultDTO = orders.stream().map(order -> OrderMapper.mapper.orderToOrderResultDto(order)).collect(Collectors.toList());
		sales.setOrderDTO(orderResultDTO);
		if(orderResultDTO.size()<0)
			throw new ModeloNotFoundException("There are no orders on the indicated dates");
		ClientDTO clientDTO = OrderMapper.mapper.clientToClienDTO(clientRepo.findByClient(orders.get(0).getClient().getId()));
		sales.setClientDTO(clientDTO);
		sales.setOrderDTO(orderResultDTO.stream().map(order ->{
					order.setDetailOrderResultDTO(
							repoDetailOrder.findByClientAndOrder(orders.get(0).getClient().getId(),order.getId()).
									stream().
									map(detailOrder ->
											OrderMapper.mapper.detailToDetailOrderResultDto(detailOrder)).collect(Collectors.toList())
					);
					order.setPaysDTO(payFeignClient.findByOrderID(order.getId()));
					return order;
				}
				).collect(Collectors.toList())
		);

		return sales;
	}


	public OrderDTO findBalanceByOrder(Integer orderID) throws Exception {
		Order order= repoOrder.findByOrderId(orderID);
		if(order==null)
			throw new ModeloNotFoundException("Order does not exist");

		List<DetailOrder> detailOrders=repoDetailOrder.findByOrderId(order.getId());

		Double balance=detailOrders.stream().
				mapToDouble( detailOrder ->
						detailOrder.getProduct().getPrice()).sum();

		order.setBalance(balance);
		OrderDTO orderDTO = OrderMapper.mapper.orderToOrderDto(order);
		return orderDTO;
	}

	public List<DetailOrderDTO> findDetailorderByOrder(Integer orderID) throws Exception {
		List<DetailOrder> detailOrderList= repoDetailOrder.findByOrderId(orderID);
		List<DetailOrderDTO> detailOrderDTO = detailOrderList.stream().map(detailOrder ->
				OrderMapper.mapper.detailOrderToDetailOrderDTO(detailOrder)).
				collect(Collectors.toList());
		return detailOrderDTO;
	}


	public void deleteOrderById(Integer orderId) throws Exception {

		PayDTO pay=payFeignClient.findByOrderID(orderId);
		if(pay!=null)
			throw new ModeloNotFoundException(
							"The order already has a payment, I can't delete the order," +
							" if you want to delete it, you need to cancel the payment");
		List<DetailOrder> detailOrders = repoDetailOrder.findByOrderId(orderId);
		if(detailOrders.size()>0)
			throw new ModeloNotFoundException(
					"The order has associated products, you must proceed to" +
							" delete the products, and then delete the order");

		repoOrder.deleteById(orderId);
	}

	public void deleteOrderCompleteById(Integer orderId) throws Exception{

		PayDTO pay=payFeignClient.findByOrderID(orderId);
		if(pay!=null)
			throw new ModeloNotFoundException(
					"The order already has a payment, I can't delete the order," +
							" if you want to delete it, you need to cancel the payment");
		List<DetailOrder> detailOrders = repoDetailOrder.findByOrderId(orderId);
		//Delete detailOrder then Delete Order
		repoDetailOrder.deleteAll(detailOrders);
		repoOrder.deleteById(orderId);

	}

	public BuysDTO insertBuys(BuysDTO buys) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setIdProduct(buys.getProductCode());
		productDTO.setTitle(buys.getProductName());
		Client client=clientRepo.findByIdOrEmail(buys.getCustomerCode(),buys.getMailCustomer());
		ProductDTO productResultDTO =productFeignClient.findByIdOrTitle(productDTO);

		if(client==null)
			throw new ModeloNotFoundException("Client does not exist");
		if(productResultDTO==null)
			throw new ModeloNotFoundException("The product does not exist");

		//Check if the customer has an active order with its associated order detail
		List<DetailOrder> detailOrderList=repoDetailOrder.
				findByClientIdOrClientEmailAndProductIdOrProductTitle
						(buys.getCustomerCode(),buys.getMailCustomer(),buys.getProductCode(),buys.getProductName());
		Product product = new Product();
		product.setIdProduct(productResultDTO.getIdProduct());


			List<Order> orders=repoOrder.findByClientesAndStatus(client.getId(),1);
			if(orders.size()<=0){
				//create new order
				Order order=createNewOrder(client,productResultDTO);
				//create new detail order
				DetailOrder detailOrder=createNewDetailOrder(order,product);
			}else{
				Order order =orders.get(0);
				PayDTO payDTO = new PayDTO();
				OrderDTO orderDTO = OrderMapper.mapper.orderToOrderDto(order);
				payDTO.setOrder(orderDTO);
				PayDTO payDtoResult=payFeignClient.findByOrder(payDTO);
				if(payDtoResult==null){
					//Customer has an active order, add order and product detail to it
					DetailOrder detailOrder=createNewDetailOrder(order,product);
				}else{
					//There is an order but it has already been paid, proceed to create a new one
					order=createNewOrder(client,productResultDTO);
					//create new detail order
					DetailOrder detailOrder=createNewDetailOrder(order,product);
				}
			}

		return buys;
	}

	private Order createNewOrder(Client client,ProductDTO productResultDTO) throws Exception {
		LocalDate localDateTime = LocalDate.now();
		Order order=new Order();
		order.setClient(client);
		order.setCreateOrderDate(localDateTime);
		order.setBalance(productResultDTO.getPrice());
		this.registrar(order);
		return order;
	}

	private DetailOrder createNewDetailOrder(Order order,Product product) throws Exception {
		LocalDate localDateTime = LocalDate.now();
		DetailOrder detailOrder= new DetailOrder();
		detailOrder.setOrder(order);
		detailOrder.setProduct(product);
		detailOrder.setCreateDetailOrderDate(localDateTime);
		detailOrderService.registrar(detailOrder);
		return detailOrder;
	}
}
