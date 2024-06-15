package com.ecommerce.controller;

import com.ecommerce.entity.Client;
import com.ecommerce.exception.ModeloNotFoundException;
import com.ecommerce.service.IClientService;
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
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping("/insert")
    public ResponseEntity<Client> insert(@Valid @RequestBody Client client, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            throw new ModeloNotFoundException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        log.info("Insertando Client '{}' will be send ... ", client);
        Client pruebaResult=clientService.registrar(client);
        log.info("Registered Client'{}' will be send ... ", client);
        return new ResponseEntity<Client>(pruebaResult, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Client>> findAll() throws Exception {
        log.info("Searching Client findAll ... ");
        List<Client> clients = clientService.listar();
        return new ResponseEntity<List<Client>>(clients,HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<Client> update(@Valid @RequestBody Client client,BindingResult bindingResult) throws Exception {
        log.info("Updating Client ... ");
        if (bindingResult.hasErrors())
            throw new ModeloNotFoundException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        Client clientResult=clientService.registrar(client);
        return new ResponseEntity<Client>(clientResult,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        log.info("Deleting Client ... ");
        if(id == 0) {
            throw new ModeloNotFoundException("ID no puede ser 0 " + id);
        }
        clientService.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}

