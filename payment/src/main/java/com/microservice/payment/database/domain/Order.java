package com.microservice.payment.database.domain;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "uuid")
    private String uuid;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> productId;

    @Column(name = "order_date")
    private Instant orderDate;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "order_paid")
    private Boolean orderPaid;

    @Override
    public String toString() {
        return "Order{" +
                "uuid='" + uuid + '\'' +
                ", productId=" + productId +
                ", orderDate=" + orderDate +
                ", quantity=" + quantity +
                ", orderPaid=" + orderPaid +
                '}';
    }
}
