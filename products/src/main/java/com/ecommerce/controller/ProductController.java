package com.ecommerce.controller;


import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.service.IProductService;
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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("/insert")
    public ResponseEntity<Product> insert(@Valid @RequestBody Product product, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            throw new ModeloNotFoundException(bindingResult.getAllErrors().get(0).getDefaultMessage());
            log.info("Inserting Product '{}' will be send ... ", product);
            Product balanceResult = productService.registrar(product);
            log.info("Registered Product'{}' will be send ... ", product);


        return new ResponseEntity<Product>(balanceResult, HttpStatus.OK);
    }

    @GetMapping("/findAllExternal")
    public ResponseEntity<List<Product>> findAllExternal() throws Exception {
        log.info("Searching Product findAllExternal ... ");
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @GetMapping("/findAllBD")
    public ResponseEntity<List<Product>> findAllBD() throws Exception {
        log.info("Searching Product findAllBD... ");
        List<Product> products = productService.listar();
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @PostMapping("/findByIdOrTitle")
    public ResponseEntity<ProductDTO> findByIdOrTitle(@RequestBody ProductDTO product) throws Exception {
        log.info("Searching Product findByIdOrTitle... ");
        ProductDTO productDTO = productService.findByProductIdOrTitle(product.getIdProduct(),product.getTitle());
        return new ResponseEntity<ProductDTO>(productDTO,HttpStatus.OK);
    }

   @GetMapping("/findAllAndSaveBD")
    public ResponseEntity<List<ProductDTO>> findAllAndSaveBD() throws Exception {
        log.info("Searching Product findAllAndSaveBD ... ");
        List<ProductDTO> products = productService.findAllProductsAnSaveBD();
        return new ResponseEntity<List<ProductDTO>>(products,HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<Product> update(@Valid @RequestBody Product product,BindingResult bindingResult) throws Exception {
        log.info("Updating Product ... ");
        if (bindingResult.hasErrors())
            throw new ModeloNotFoundException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        Product productResult=productService.registrar(product);
        return new ResponseEntity<Product>(productResult,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        log.info("Deleting Product ... ");
        if(id == 0) {
            throw new ModeloNotFoundException("D cannot be 0 " + id);
        }
        productService.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}

