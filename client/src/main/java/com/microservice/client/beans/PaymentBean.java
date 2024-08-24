package com.microservice.client.beans;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentBean {

    private String uuid;
    private OrderBean orderId;
    private BigDecimal cost;
    private Long cardNumber;
}
