package com.ecommerce.service;


import com.ecommerce.entity.Client;

public interface IClientService extends ICRUD<Client, Integer> {
    public Client findByUser_name(String name);
}
