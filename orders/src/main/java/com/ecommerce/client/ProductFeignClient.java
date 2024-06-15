package com.ecommerce.client;

import com.ecommerce.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="productFeignClient", url="${product.api.base-url}", configuration = FeignClientConfiguration.class)
public interface ProductFeignClient {

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,value = "/product/findByIdOrTitle")
    ProductDTO findByIdOrTitle(@RequestBody ProductDTO productDTO);

}
