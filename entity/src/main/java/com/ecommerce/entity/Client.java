package com.ecommerce.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "client")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "cliente_id_seq")
    @SequenceGenerator(
            name = "cliente_id_seq",
            sequenceName = "cliente_id_seq",
            initialValue = 1,
            allocationSize=1
    )
    private Integer id;

    @Size(min =3, max = 50, message = "{client.name.size}")
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Size(min =3, max = 50, message = "{client.lastName.size}")
    @Column(name = "lastname", nullable = false, length = 50)
    private String lastName;
    @Column(name = "birthday", columnDefinition = "DATE")
    private LocalDate birthday;
    @Size(max = 20, message = "{client.phone.size}")
    @Column(name = "phone", nullable = true, length = 20)
    private String phone;
    @Size(max = 50, message = "{client.email.size}")
    @Column(name = "email", nullable = true, length = 50)
    private String email;
    @Size(max = 100, message = "{client.adresss.size}")
    @Column(name = "adresss", nullable = true, length = 100)
    private String adresss;


}
