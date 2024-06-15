package com.ecommerce.repo;


import com.ecommerce.entity.Client;
import org.springframework.data.jpa.repository.Query;

public interface IClientRepo extends IGenericRepo<Client, Integer>{
    @Query("SELECT u FROM Client u WHERE u.name = ?1")
    public Client findByName(String user_name);
    @Query("SELECT u FROM Client u WHERE u.id = ?1")
    public Client findByClient(Integer client);
}
