package com.ecommerce.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;


@Data
public class DetailOrderDTO {

    private Integer id;
    private LocalDate createDetailOrderDate;
    @Size(max = 20, message = "Para el Campo amount el Maximo Permitido es 20")
    private Double amount;
    private OrderDTO order;
    private ProductDTO product;
}
