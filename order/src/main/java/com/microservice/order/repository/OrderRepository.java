package com.microservice.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.order.database.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

}
