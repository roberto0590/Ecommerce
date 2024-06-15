package com.ecommerce.dto;

import lombok.Data;

@Data
public class BuysDTO {

    private Integer customerCode;
    private String mailCustomer;
    private Integer productCode;
    private String  productName;
    private Integer orderCode;

    private String fecha1;
    private String fecha2;
}
