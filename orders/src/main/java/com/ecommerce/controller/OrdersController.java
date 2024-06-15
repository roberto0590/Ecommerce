package com.ecommerce.controller;


import com.ecommerce.dto.*;
import com.ecommerce.entity.Order;
import com.ecommerce.service.IOrdersService;
import com.ecommerce.exception.ModeloNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @PostMapping("/insert")
    public ResponseEntity<Order> insert(@Valid @RequestBody Order order,BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            throw new ModeloNotFoundException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        log.info("Inserting Order '{}' will be send ... ", order);
        Order balanceResult=ordersService.registrar(order);
        log.info("Registered Order'{}' will be send ... ", order);
        return new ResponseEntity<Order>(balanceResult, HttpStatus.OK);
    }

    @PostMapping("/buys")
    public ResponseEntity<BuysDTO> buys(@Valid @RequestBody BuysDTO buys,BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            throw new ModeloNotFoundException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        log.info("Inserting Order '{}' will be send ... ", buys);
        BuysDTO buysResult=ordersService.insertBuys(buys);
        log.info("Registered Order '{}' will be send ... ", buys);
        return new ResponseEntity<BuysDTO>(buysResult, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Order>> findAll() throws Exception {
        log.info("Realizando Busqueda ... ");
        List<Order> orders = ordersService.listar();
        return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);

    }

    @PostMapping("/findOrderByClient")
    public ResponseEntity<Sales> findOrderByClient(@Valid @RequestBody BuysDTO buysDTO) throws Exception {
        log.info("Searching Order findOrderByClient... ");
        Sales orders = ordersService.findOrderByClient(buysDTO.getCustomerCode(),buysDTO.getMailCustomer());
        return new ResponseEntity<Sales>(orders,HttpStatus.OK);

    }

    @PostMapping("/findOrderByDate")
    public ResponseEntity<Sales> findOrderByDate(@Valid @RequestBody BuysDTO buysDTO) throws Exception {
        log.info("Searching Order findOrderByClient... ");
        Sales orders = ordersService.findOrderByDate(buysDTO.getFecha1(),buysDTO.getFecha2());
        return new ResponseEntity<Sales>(orders,HttpStatus.OK);

    }

    @GetMapping("/findBalanceByOrder/{id}")
    public ResponseEntity<OrderDTO> findBalanceByOrder(@PathVariable("id") Integer id) throws Exception {
        log.info("Searching Order findBalanceByOrder... ");
        OrderDTO orderDTO = ordersService.findBalanceByOrder(id);
        return new ResponseEntity<OrderDTO>(orderDTO,HttpStatus.OK);
    }

    @GetMapping("/findDetailOrderByOrder/{id}")
    public ResponseEntity<List<DetailOrderDTO>> findDetailOrderByOrder(@PathVariable("id") Integer id) throws Exception {
        log.info("Searching Order findDetailOrderByOrder ... ");
        List<DetailOrderDTO>  detailOrdersDTO = ordersService.findDetailorderByOrder(id);
        return new ResponseEntity<List<DetailOrderDTO>>(detailOrdersDTO,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Order> update(@Valid @RequestBody Order order, BindingResult bindingResult) throws Exception {
        log.info("Updating Order ... ");
        if (bindingResult.hasErrors())
            throw new ModeloNotFoundException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        Order balanceResult=ordersService.registrar(order);
        return new ResponseEntity<Order>(balanceResult,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws Exception {
        log.info("Deleting Order ... ");
        if(id == 0) {
            throw new ModeloNotFoundException("ID cannot be 0 " + id);
        }
        ordersService.deleteOrderById(id);
        return new ResponseEntity<String>("Order removed",HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteOrderComplete/{id}")
    public ResponseEntity<String> deleteOrderComplete(@PathVariable("id") Integer id) throws Exception {
        log.info("Deleting Order ... ");
        if(id == 0) {
            throw new ModeloNotFoundException("ID cannot be 0 " + id);
        }
        ordersService.deleteOrderCompleteById(id);
        return new ResponseEntity<String>("Order complete removed",HttpStatus.NO_CONTENT);
    }
}

