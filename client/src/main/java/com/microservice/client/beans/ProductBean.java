package com.microservice.client.beans;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class ProductBean {
    private String uuid;
    private String title;
    private String description;
    private String image;
    private BigDecimal price;

    @Override
    public String toString() {
        return "ProductBean{" +
        "uuid='" + uuid + '\'' +
        ", description='" + description + '\'' +
        ", image='" + image + '\'' +
        ", price=" + price +
        '}';
    }
}
