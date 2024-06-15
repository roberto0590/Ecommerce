package com.ecommerce.service.impl;

import com.ecommerce.client.OrderFeignClient;
import com.ecommerce.dto.DetailOrderDTO;
import com.ecommerce.dto.OrderDTO;
import com.ecommerce.dto.PayDTO;
import com.ecommerce.dto.PayOrderDTO;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.Pay;
import com.ecommerce.exception.ModeloNotFoundException;
import com.ecommerce.mapper.PayMapper;
import com.ecommerce.repo.IPayRepo;
import com.ecommerce.service.IPayService;
import com.ecommerce.repo.IGenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayServiceImpl extends CRUDImpl<Pay, Integer> implements IPayService {

	@Autowired
	private IPayRepo repoPay;
	@Autowired
	private OrderFeignClient orderFeignClient;
	
	@Override
	protected IGenericRepo<Pay, Integer> getRepo() {
		return repoPay;
	}

	public PayDTO findByOrder(Integer orderID) {
		Pay pay = repoPay.findByOrderID(orderID);
		PayDTO payDTO = PayMapper.mapper.payToPayDto(pay);
		return payDTO;
	}
	public List<PayDTO>  findByOrderClientID(Integer clientID) throws Exception {
		List<Pay> pays = repoPay.findByOrderClientID(clientID);
		List<PayDTO> paysDTO =pays.stream().map(pay -> PayMapper.mapper.payToPayDto(pay)).collect(Collectors.toList());
		return paysDTO;
	}


	public PayDTO insertPayment(Integer id) throws Exception{
		LocalDate localDateTime = LocalDate.now();
		Pay pay = repoPay.findByOrderID(id);
		if(id==null)
			throw new ModeloNotFoundException("The order number cannot be null");
		if(pay!=null)
			throw new ModeloNotFoundException("The order already has a payment");

		OrderDTO orderDTO=orderFeignClient.findBalanceByOrder(id);
		if(orderDTO==null)
			throw new ModeloNotFoundException("Order does not exist");

		List<DetailOrderDTO> detailOrderDTOList=orderFeignClient.findDetailOrderByOrder(id);
		if(detailOrderDTOList.size()<=0)
			throw new ModeloNotFoundException("The order does not have associated products");
			Order order = PayMapper.mapper.orderDtoToOrder(orderDTO);
			pay=new Pay();
			pay.setPayDate(localDateTime);
			pay.setOrder(order);
			pay.setTotal(orderDTO.getBalance());

			repoPay.save(pay);

			order.setStatus(1);

			orderFeignClient.update(order);

		PayDTO payDTO=PayMapper.mapper.payToPayDto(pay);
		return payDTO;
	}

}
