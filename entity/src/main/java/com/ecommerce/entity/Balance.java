package com.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "BALANCE")
public class Balance {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "balance_id_seq")
    @SequenceGenerator(
            name = "balance_id_seq",
            sequenceName = "balance_id_seq",
            initialValue = 1,
            allocationSize=1
    )
    private Integer id;
    @Column(name = "CREATEDDATE", columnDefinition = "TIME WITH TIME ZONE")
    private LocalDate createDate;
    @Size(min =3, max = 20, message = "Para el Campo name el Minimo Requerido es 3 & Maximo Permitido es 20")
    @Column(name = "ACCOUNT", nullable = false, length = 20)
    private String account;
    @Column(name = "BALANCE", nullable = false)
    private Double balance;
    @ManyToOne
    @JoinColumn(name = "CLIENT", nullable = false, foreignKey = @ForeignKey(name = "CLIENT_FK"))
    private Client cliente;
}
