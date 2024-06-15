package com.ecommerce.mapper;

import com.ecommerce.dto.*;
import com.ecommerce.entity.Client;
import com.ecommerce.entity.DetailOrder;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "order")
public interface OrderMapper {

    OrderMapper mapper = Mappers.getMapper(OrderMapper.class);

   // @Mapping(source = "imagePath" , target = "imageUrl")
    OrderDTO orderToOrderDto(Order order);

    //@Mapping(source = "imageUrl" , target = "imagePath")
    Order orderDtoToOrder(OrderDTO orderDTO);

    OrderResultDTO orderToOrderResultDto(Order order);

    DetailOrderResultDTO detailToDetailOrderResultDto(DetailOrder detailOrder);

    ClientDTO clientToClienDTO(Client client);

    DetailOrderDTO detailOrderToDetailOrderDTO(DetailOrder detailOrder);
}

