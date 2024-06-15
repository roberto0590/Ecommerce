package com.ecommerce.client;

import com.ecommerce.dto.BuysDTO;
import com.ecommerce.dto.DetailOrderDTO;
import com.ecommerce.dto.PayDTO;
import com.ecommerce.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="payFeignClient", url="${pay.api.base-url}", configuration = FeignClientConfiguration.class)
public interface PayFeignClient {

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,value = "/pay/findByOrder")
    PayDTO findByOrder(@RequestBody PayDTO payDTO);

    @RequestMapping(method = RequestMethod.GET, value = "/pay/findByOrderID/{id}", consumes = "application/json")
    PayDTO findByOrderID(@PathVariable("id") Integer id);
}
