package com.microservice.product.database.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column
    private String uuid;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "prix")
    private BigDecimal prix;
}
