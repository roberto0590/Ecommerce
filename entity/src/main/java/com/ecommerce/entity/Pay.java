package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "pay")
public class Pay {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "pay_id_seq")
    @SequenceGenerator(
            name = "pay_id_seq",
            sequenceName = "pay_id_seq",
            initialValue = 1,
            allocationSize=1
    )
    private Integer id;
    @Column(name = "pay_date")
    private LocalDate payDate;
    @Column(name = "balance", nullable = false)
    private Double total;
    @ManyToOne
    @JoinColumn(name = "orders", nullable = false, foreignKey = @ForeignKey(name = "ORDER_FK2"))
    private Order order;
}
