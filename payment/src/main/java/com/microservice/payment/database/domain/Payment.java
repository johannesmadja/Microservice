package com.microservice.payment.database.domain;

import java.math.BigDecimal;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {
    @Id
    @UuidGenerator()
    @Column
    private String uuid;

    @Column(name = "order_id")
    private Order orderId;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "card_number")
    private Integer cardNumber;

}
