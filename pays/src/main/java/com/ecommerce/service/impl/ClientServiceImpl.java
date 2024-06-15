package com.ecommerce.service.impl;


import com.ecommerce.entity.Client;
import com.ecommerce.repo.IClientRepo;
import com.ecommerce.repo.IGenericRepo;
import com.ecommerce.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends CRUDImpl<Client, Integer> implements IClientService {

	@Autowired
	private IClientRepo repo;
	
	@Override
	protected IGenericRepo<Client, Integer> getRepo() {
		return repo;
	}

	public Client findByUser_name(String user_name){
		Client usuario = repo.findByName(user_name);
		return usuario;
	}

}
