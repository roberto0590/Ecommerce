package com.ecommerce.repo;

import com.ecommerce.entity.Pay;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPayRepo extends IGenericRepo<Pay, Integer>{
    @Query("SELECT p FROM Pay p WHERE p.order.id = ?1")
    public Pay findByOrderID(Integer order);
    @Query("SELECT p FROM Pay p WHERE p.id = ?1")
    public Pay findByPayId(Integer id);
    @Query("SELECT p FROM Pay p WHERE p.order.client.id = ?1")
    public List<Pay> findByOrderClientID(Integer clientID);

}
