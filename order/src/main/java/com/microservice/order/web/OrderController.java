package com.microservice.order.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.order.database.OrderDto;
import com.microservice.order.database.domain.Order;
import com.microservice.order.database.mapping.OrderMapper;
import com.microservice.order.services.OrderService;

@RestController
@RequestMapping("/order")   
public class OrderController {
    
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(
        OrderService orderService,
        OrderMapper orderMapper
    ) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable String id) {
        OrderDto orderDto = orderMapper.mapOrderToDto(this.orderService.getOrder(id));

        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody Order order) {
        OrderDto orderDto = orderMapper.mapOrderToDto(this.orderService.createOrder(order));

        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }
}
