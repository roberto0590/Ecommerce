package com.ecommerce.controller;

import com.ecommerce.dto.PayDTO;
import com.ecommerce.entity.Pay;
import com.ecommerce.service.IPayService;
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
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private IPayService payService;

    @PostMapping("/insert/{id}")
    public ResponseEntity<PayDTO> insert(@PathVariable("id") Integer id) throws Exception {
        log.info("Inserting Pay '{}' will be send ... ", id);
        PayDTO payResult=payService.insertPayment(id); //id is order number
        log.info("Registered Pay'{}' will be send ... ", id);
        return new ResponseEntity<PayDTO>(payResult, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Pay>> findAll() throws Exception {
        log.info("Searching Pay findAll ... ");
        List<Pay> pays = payService.listar();
        return new ResponseEntity<List<Pay>>(pays,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Pay> update(@Valid @RequestBody Pay pay, BindingResult bindingResult) throws Exception {
        log.info("SUpdating Pay ... ");
        if (bindingResult.hasErrors())
            throw new ModeloNotFoundException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        Pay balanceResult=payService.registrar(pay);
        return new ResponseEntity<Pay>(balanceResult,HttpStatus.OK);
    }

    @PostMapping("/findByOrder")
    public ResponseEntity<PayDTO> findByOrder(@RequestBody PayDTO payDTO) throws Exception {
        log.info("Searching Pay findByOrder ... ");
        PayDTO payResultDTO = payService.findByOrder(payDTO.getOrder().getId());
        return new ResponseEntity<PayDTO>(payResultDTO,HttpStatus.OK);
    }


    @GetMapping("/findByOrderClientID/{id}")
    public ResponseEntity<List<PayDTO>> findByOrderClientID(@PathVariable("id") Integer id) throws Exception {
        log.info("Searching Pay findByOrderClientID ... ");
        List<PayDTO>  payResultDTO = payService.findByOrderClientID(id);
        return new ResponseEntity<List<PayDTO> >(payResultDTO,HttpStatus.OK);
    }

    @GetMapping("/findByOrderID/{id}")
    public ResponseEntity<PayDTO> findByOrderID(@PathVariable("id") Integer id) throws Exception {
        log.info("Searching Pay findByOrderID ... ");
        PayDTO payResultDTO = payService.findByOrder(id);
        return new ResponseEntity<PayDTO>(payResultDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        log.info("Deleting Pay ... ");
        if(id == 0) {
            throw new ModeloNotFoundException("D cannot be 0 " + id);
        }
        payService.deletePayById(id);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}

