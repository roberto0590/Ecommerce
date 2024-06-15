package com.ecommerce.dto;

import com.ecommerce.entity.Client;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderResultDTO {

    private Integer id;
    private LocalDate createOrderDate;
    @Size(max = 20, message = "Para el Campo balance el Maximo Permitido es 20")
    private Double balance;
    private List<DetailOrderResultDTO> detailOrderResultDTO = new ArrayList<>();
    private PayDTO paysDTO = new PayDTO();

}
