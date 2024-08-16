package com.microservice.order.database.domain;

import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @UuidGenerator()
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

    @PrePersist
    public void prePersist() {
        this.uuid = this.getClass().getSimpleName().toLowerCase() + this.uuid;
    }
}
