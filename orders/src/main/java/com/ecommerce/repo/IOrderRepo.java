package com.ecommerce.repo;

import com.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

//@Repository
public interface IOrderRepo extends IGenericRepo<Order, Integer>{
    @Query("SELECT o FROM Order o WHERE o.client.id = ?1")
    public List<Order> findByClientes(Integer client);
    @Query("SELECT o FROM Order o WHERE o.client.id = ?1")
    public Order findByCliente(Integer client);
    @Query("SELECT o FROM Order o WHERE o.id = ?1")
    public Order findByOrderId(Integer id);
    @Query("SELECT o FROM Order o WHERE o.client.id = ?1 or o.client.email= ?2" )
    public List<Order> findByClientIdOrClientEmail(Integer clientId, String clientMail);
    @Query("SELECT o FROM Order o WHERE o.client.id = ?1 and o.status is null")
    public List<Order> findByClientesAndStatus(Integer client,Integer status);

    @Query("SELECT o FROM Order o WHERE o.createOrderDate between ?1 and ?2" )
    public List<Order> findByOrderDate(LocalDate date1, LocalDate date2);

}
