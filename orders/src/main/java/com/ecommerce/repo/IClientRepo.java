package com.ecommerce.repo;


import com.ecommerce.entity.Client;
import org.springframework.data.jpa.repository.Query;

//@Repository
public interface IClientRepo extends IGenericRepo<Client, Integer>{
    @Query("SELECT c FROM Client c WHERE c.name = ?1")
    public Client findByName(String user_name);
    @Query("SELECT c FROM Client c WHERE c.id = ?1")
    public Client findByClient(Integer client);
    @Query("SELECT c FROM Client c WHERE c.id = ?1 or c.email =?2")
    public Client findByIdOrEmail(Integer client,String mail);
}
