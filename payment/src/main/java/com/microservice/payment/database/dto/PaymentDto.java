package com.microservice.payment.database.dto;

import java.math.BigDecimal;

import com.microservice.payment.database.domain.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDto {
    private Order orderId;
    private BigDecimal cost;
    private Integer cardNumber;
}
