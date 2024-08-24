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

        /**
     * Retrieves an Order object based on the provided order ID.
     *
     * @param id    the ID of the order to be retrieved
     * @return      the Order object associated with the given ID, or null if not found
     */
    public Order getOrder(String id) {
        return this.orderRepository.findById(id).orElse(null);
    }

        /**
     * Creates an order by saving it to the order repository.
     *
     * @param  order  the order to be created
     * @return        the created order
     */
    public Order createOrder(Order order) {
        return this.orderRepository.save(order);
    }

        /**
     * Checks if an order with the given ID exists in the order repository.
     *
     * @param  id  the ID of the order to check
     * @return     true if an order with the given ID exists, false otherwise
     */
    public boolean existsOrder(String id) {
        return this.orderRepository.existsById(id);
    }

    public void update(String id) {
        this.orderRepository.update(id);
    }





}
