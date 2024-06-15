package com.ecommerce.mapper;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

   // @Mapping(source = "imagePath" , target = "imageUrl")
    ProductDTO productToProductDto(Product product);

    //@Mapping(source = "imageUrl" , target = "imagePath")
    Product productDtoToProduct(ProductDTO productDTO);

}
