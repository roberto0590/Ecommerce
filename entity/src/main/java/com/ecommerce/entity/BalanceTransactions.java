package com.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "BALANCE_TRANSACTIONS")
public class BalanceTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "balance_transactions_id_seq")
    @SequenceGenerator(
            name = "balance_transactions_id_seq",
            sequenceName = "balance_transactions_id_seq",
            initialValue = 1,
            allocationSize=1
    )
    private Integer id;

    @Column(name = "CREATEDDATE", columnDefinition = "TIME WITH TIME ZONE")
    private LocalDate createDate;
    @ManyToOne
    @JoinColumn(name = "CLIENT", nullable = false, foreignKey = @ForeignKey(name = "BALANCE_TRANSACTIONS_CLIENT_FK"))
    private Client cliente;
    @Size(min =3, max = 20, message = "Para el Campo name el Minimo Requerido es 3 & Maximo Permitido es 20")
    @Column(name = "ACCOUNT", nullable = false, length = 20)
    private String account;
    @Column(name = "AMOUNT", nullable = true)
    private Double amount;



}
