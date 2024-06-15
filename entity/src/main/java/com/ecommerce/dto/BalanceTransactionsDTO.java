package com.ecommerce.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BalanceTransactionsDTO {

    private Integer id;
    private LocalDate createDate;
    private ClientDTO cliente;
    @Column(name = "ACCOUNT", nullable = false, length = 20)
    private String account;
    @Column(name = "AMOUNT", nullable = true)
    private Double amount;



}
