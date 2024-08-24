package com.microservice.client.beans;

import java.time.Instant;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderBean {
    private String uuid;
    private List<ProductBean> products;
    private Instant orderDate;
    private Integer quantity;
    private Boolean orderPaid;
}
