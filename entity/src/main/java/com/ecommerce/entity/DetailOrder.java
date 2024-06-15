package com.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "detail_order")
public class DetailOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "detail_order_id_seq")
    @SequenceGenerator(
            name = "detail_order_id_seq",
            sequenceName = "detail_order_id_seq",
            initialValue = 1,
            allocationSize=1
    )
    private Integer id;
    @Column(name = "create_detail_order_date")
    private LocalDate createDetailOrderDate;
    @Column(name = "amount", nullable = true)
    private Double amount;
    @ManyToOne
    @JoinColumn(name = "orders", nullable = false, foreignKey = @ForeignKey(name = "ORDER_FK1"))
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product", nullable = false, foreignKey = @ForeignKey(name = "PRODUCT_FK1"))
    private Product product;
}
