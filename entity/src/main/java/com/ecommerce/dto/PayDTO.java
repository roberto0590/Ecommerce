package com.ecommerce.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PayDTO {


    private Integer id;
    private LocalDate payDate;
    private Double total;
    private OrderDTO order;
}
