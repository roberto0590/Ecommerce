package com.ecommerce.service;

import com.ecommerce.dto.PayDTO;
import com.ecommerce.dto.PayOrderDTO;
import com.ecommerce.entity.Pay;
import com.ecommerce.exception.ModeloNotFoundException;

import java.util.List;


public interface IPayService extends ICRUD<Pay, Integer> {
    public PayDTO findByOrder(Integer orderID);
    public PayDTO insertPayment(Integer id) throws Exception;
    public List<PayDTO> findByOrderClientID(Integer clientID) throws Exception;
}
