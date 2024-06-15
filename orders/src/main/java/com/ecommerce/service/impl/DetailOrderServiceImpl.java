package com.ecommerce.service.impl;

import com.ecommerce.entity.BalanceTransactions;
import com.ecommerce.entity.DetailOrder;
import com.ecommerce.repo.IOrderRepo;
import com.ecommerce.service.IOrdersService;
import com.ecommerce.service.IDetailOrderService;
import com.ecommerce.repo.IDetailOrderRepo;
import com.ecommerce.repo.IClientRepo;
import com.ecommerce.repo.IGenericRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DetailOrderServiceImpl extends CRUDImpl<DetailOrder, Integer> implements IDetailOrderService {

	@Autowired
	private IDetailOrderRepo repoDetailOrder;

	@Override
	protected IGenericRepo<DetailOrder, Integer> getRepo() {
		return repoDetailOrder;
	}

	public DetailOrder findByCliente(Integer order){
		DetailOrder balanceTransactions = repoDetailOrder.findByOrder(order);
		return balanceTransactions;
	}

}
