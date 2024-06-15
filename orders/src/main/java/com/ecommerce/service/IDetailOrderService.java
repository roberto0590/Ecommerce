package com.ecommerce.service;

import com.ecommerce.entity.BalanceTransactions;
import com.ecommerce.entity.DetailOrder;

public interface IDetailOrderService extends ICRUD<DetailOrder, Integer> {
    public DetailOrder findByCliente(Integer client);
}
