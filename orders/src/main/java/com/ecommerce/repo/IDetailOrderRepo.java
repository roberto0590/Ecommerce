package com.ecommerce.repo;


import com.ecommerce.entity.BalanceTransactions;

import com.ecommerce.entity.DetailOrder;
import com.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//@Repository
public interface IDetailOrderRepo extends IGenericRepo<DetailOrder, Integer>{
    @Query("SELECT do FROM DetailOrder do WHERE do.order.id = ?1")
    public DetailOrder findByOrder(Integer order);
    @Query("SELECT do FROM DetailOrder do WHERE do.id = ?1")
    public DetailOrder findByOrderDetailId(Integer detailOrder);
    @Query("SELECT do FROM DetailOrder do WHERE do.order.client.id = ?1 and do.order.id = ?2")
    public List<DetailOrder> findByClientAndOrder(Integer cliente, Integer order);
    @Query("SELECT do FROM DetailOrder do WHERE do.order.client.id = ?1")
    public List<DetailOrder> findByClientes(Integer cliente);
    @Query("SELECT do FROM DetailOrder do WHERE do.order.id = ?1")
    public List<DetailOrder> findByOrderId(Integer order);
    @Query("SELECT do FROM DetailOrder do WHERE (do.order.client.id = ?1 or do.order.client.email= ?2) and (do.product.idProduct = ?3 or do.product.title = ?4)" )
    public List<DetailOrder> findByClientIdOrClientEmailAndProductIdOrProductTitle(Integer clientId, String clientMail, Integer productId, String title);
}
