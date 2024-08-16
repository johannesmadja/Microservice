package com.microservice.order.services;

import org.springframework.stereotype.Service;

import com.microservice.order.database.domain.Order;
import com.microservice.order.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(
        OrderRepository orderRepository
    ) {
        this.orderRepository = orderRepository;
    }

    public Order getOrder(String id) {
        return this.orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        return this.orderRepository.save(order);
    }



}
