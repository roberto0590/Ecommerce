package com.ecommerce.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Sales {

    private ClientDTO clientDTO = new ClientDTO();
    private List<OrderResultDTO> orderDTO = new ArrayList<>();

}
