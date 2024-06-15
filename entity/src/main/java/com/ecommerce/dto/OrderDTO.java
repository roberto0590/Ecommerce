package com.ecommerce.dto;

import com.ecommerce.entity.Client;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;


@Data
public class OrderDTO {

    private Integer id;
    private LocalDate createOrderDate;
    private Double balance;
    private Client client;
}
