package com.ecommerce.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {

    private Integer idProduct;
    @Size(min =3, max = 500, message = "Para el Campo name el Minimo Requerido es 2 & Maximo Permitido es 500")
    private String title;
    @Size(max = 20, message = "Para el Campo price el Maximo Permitido es 20")
    private Double price;
    @Size(max = 500, message = "Para el Campo description el Maximo Permitido es 1000")
    private String description;
    @Size(max = 100, message = "Para el Campo category el Maximo Permitido es 100")
    private String category;
    @Size(max = 200, message = "Para el Campo image el Maximo Permitido es 200")
    private String image;


}
