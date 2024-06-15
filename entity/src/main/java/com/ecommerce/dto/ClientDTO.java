package com.ecommerce.dto;


import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientDTO {


    private Integer id;
    @Size(min =3, max = 50, message = "Para el Campo name el Minimo Requerido es 3 & Maximo Permitido es 50")
    private String name;
    @Size(min =3, max = 50, message = "Para el Campo lastName el Minimo Requerido es 3 & Maximo Permitido es 50")
    private String lastName;
    private LocalDate birthday;
    @Size(max = 20, message = "Para el Campo phone el Maximo Permitido es 20")
    private String phone;
    @Size(max = 50, message = "Para el Campo email el Maximo Permitido es 50")
    private String email;
    @Size(max = 100, message = "Para el Campo adresss el Maximo Permitido es 20")
    private String adresss;

}
