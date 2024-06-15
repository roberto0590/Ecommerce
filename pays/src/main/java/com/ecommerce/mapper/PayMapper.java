package com.ecommerce.mapper;

import com.ecommerce.dto.OrderDTO;
import com.ecommerce.dto.PayDTO;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.Pay;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "pay")
public interface PayMapper {

    PayMapper mapper = Mappers.getMapper(PayMapper.class);

   // @Mapping(source = "imagePath" , target = "imageUrl")
    PayDTO payToPayDto(Pay pay);

    //@Mapping(source = "imageUrl" , target = "imagePath")
    Pay payDtoToPay(PayDTO payDTO);

    Order orderDtoToOrder(OrderDTO orderDTO);

}
