package com.microservice.product.database.mapping;

import org.mapstruct.Mapper;

import com.microservice.common.utils.mapStruct.EntityMapper;
import com.microservice.product.database.ProductDto;
import com.microservice.product.database.domain.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDto, Product> {
    ProductDto maProductDto(Product product);
}
