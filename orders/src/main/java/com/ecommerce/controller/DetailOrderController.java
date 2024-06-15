package com.ecommerce.controller;

import com.ecommerce.entity.DetailOrder;
import com.ecommerce.service.IDetailOrderService;
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
@RequestMapping("/detailOrder")
public class DetailOrderController {

    @Autowired
    private IDetailOrderService detailOrderService;

    @PostMapping("/insert")
    public ResponseEntity<DetailOrder> insert(@Valid @RequestBody DetailOrder detailOrder, BindingResult bindingResult) throws Exception,ModeloNotFoundException {
        if (bindingResult.hasErrors())
            throw new ModeloNotFoundException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        log.info("Inserting DetailOrder '{}' will be send ... ", detailOrder);
        DetailOrder detailOrderResult = new DetailOrder();
        try {
           // balanceTransactionsResult = balanceTransactionsService.regsitrarBalanceTransaccion(balanceTransactions);
            log.info("Registered DetailOrder'{}' will be send ... ", detailOrder);
            return new ResponseEntity<DetailOrder>(detailOrderResult, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<DetailOrder>(detailOrderResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/findAll")
    public ResponseEntity<List<DetailOrder>> findAll() throws Exception {
        log.info("Searching DetailOrder findAll ... ");
        List<DetailOrder> detailOrders = detailOrderService.listar();
        return new ResponseEntity<List<DetailOrder>>(detailOrders,HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<DetailOrder> update(@Valid @RequestBody DetailOrder detailOrder,BindingResult bindingResult) throws Exception {
        log.info("Updating DetailOrder ... ");
        if (bindingResult.hasErrors())
            throw new ModeloNotFoundException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        DetailOrder balanceTransactionsResult=detailOrderService.registrar(detailOrder);
        return new ResponseEntity<DetailOrder>(balanceTransactionsResult,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws Exception {
        log.info("Deleting DetailOrder ... ");
        if(id == 0) {
            throw new ModeloNotFoundException("D cannot be 0" + id);
        }
        detailOrderService.deleteDetailOrderById(id);
        return new ResponseEntity<String>("Order product removed",HttpStatus.NO_CONTENT);
    }
}

