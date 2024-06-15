package com.ecommerce.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "product")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_id_seq")
    @SequenceGenerator(
            name = "product_id_seq",
            sequenceName = "product_id_seq",
            initialValue = 1,
            allocationSize=1
    )
    private Integer idProduct =null;

    @Size(min =3, max = 1000,  message = "{product.title.size}")
    @Column(name = "title", nullable = true, length = 1000)
    private String title;
    @Column(name = "price", nullable = true)
    private Double price;
    @Column(name = "description", nullable = true, length = 1000)
    @Size(max = 1000, message = "{product.description.size}")
    private String description;
    @Size(max = 1000, message = "{product.category.size}")
    @Column(name = "category", nullable = true, length = 1000)
    private String category;
    @Size(max = 1000, message = "{product.image.size}")
    @Column(name = "image", nullable = true, length = 1000)
    private String image;


}
