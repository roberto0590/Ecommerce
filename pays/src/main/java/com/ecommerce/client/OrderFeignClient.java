package com.ecommerce.client;

import com.ecommerce.dto.DetailOrderDTO;
import com.ecommerce.dto.OrderDTO;
import com.ecommerce.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="orderFeignClient", url="${order.api.base-url}", configuration = FeignClientConfiguration.class)
public interface OrderFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/orders/findBalanceByOrder/{id}", consumes = "application/json")
    OrderDTO findBalanceByOrder(@PathVariable("id") Integer id);

    @RequestMapping(method = RequestMethod.GET, value = "/orders/findDetailOrderByOrder/{id}", consumes = "application/json")
    List<DetailOrderDTO> findDetailOrderByOrder(@PathVariable("id") Integer id);

    @PutMapping( value = "/orders/update", consumes = "application/json")
    Order update(@RequestBody Order order);


}
