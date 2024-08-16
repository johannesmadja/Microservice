package com.microservice.order.database.mapping;

import org.mapstruct.Mapper;

import com.microservice.common.utils.mapStruct.EntityMapper;
import com.microservice.order.database.OrderDto;
import com.microservice.order.database.domain.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<OrderDto, Order> {    
    OrderDto mapOrderToDto(Order order);
}
