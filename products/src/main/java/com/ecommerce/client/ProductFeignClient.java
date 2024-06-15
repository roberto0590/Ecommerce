package com.ecommerce.client;

import com.ecommerce.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="productFeignClient", url="${external.fakestoreapi.base-url}", configuration = FeignClientConfiguration.class)
public interface ProductFeignClient {

    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,value = "/products")
    List<Product> getProducts();

    @RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
    Product update(@PathVariable("storeId") Long storeId, Product store);

}
