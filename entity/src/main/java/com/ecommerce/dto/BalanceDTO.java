package com.ecommerce.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BalanceDTO {

    private Integer id;
    private LocalDate createDate;
    @Size(min =3, max = 20, message = "Para el Campo name el Minimo Requerido es 3 & Maximo Permitido es 20")
    private String account;
    private Double balance;
    private ClientDTO cliente;
}
