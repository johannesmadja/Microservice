package com.microservice.order.database;

import java.time.Instant;
import java.util.List;

import com.microservice.order.database.domain.Product;

public class OrderDto {
    private List<Product> productId;
    private Instant orderDate;
    private Integer quantity;
    private Boolean orderPaid;
}
