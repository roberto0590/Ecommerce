package com.ecommerce.service;

import com.ecommerce.dto.BuysDTO;
import com.ecommerce.dto.DetailOrderDTO;
import com.ecommerce.dto.OrderDTO;
import com.ecommerce.dto.Sales;
import com.ecommerce.entity.Order;

import java.util.List;


public interface IOrdersService extends ICRUD<Order, Integer> {
    public List<Order> findByClientes(Integer client);
    public BuysDTO insertBuys(BuysDTO buys) throws Exception;
    public Sales findOrderByClient(Integer client, String mail);
    public OrderDTO findBalanceByOrder(Integer order) throws Exception;
    public List<DetailOrderDTO>  findDetailorderByOrder(Integer orderID) throws Exception;
    public Sales findOrderByDate(String date1, String date2) throws Exception;
}
