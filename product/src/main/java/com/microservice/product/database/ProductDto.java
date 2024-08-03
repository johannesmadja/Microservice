package com.microservice.product.database;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private String uuid;
    private String title;
    private String description;
    private String image;
    private BigDecimal price;
}
