package com.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "order_id_seq")
    @SequenceGenerator(
            name = "order_id_seq",
            sequenceName = "order_id_seq",
            initialValue = 1,
            allocationSize=1
    )
    private Integer id;
    @Column(name = "create_order_date")
    private LocalDate createOrderDate;
    @Column(name = "balance", nullable = false)
    private Double balance;
    @Column(name = "status", nullable = true)
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "client", nullable = false, foreignKey = @ForeignKey(name = "CLIENT_FK"))
    private Client client;
}
