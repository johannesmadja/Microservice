package com.microservice.product.database.domain;

import java.math.BigDecimal;

import org.hibernate.annotations.UuidGenerator;

import com.microservice.common.utils.generator.IdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @Column
    private String uuid;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "prix")
    private BigDecimal price;


    @Override
    public String toString() {
        return "Product{" +
                "uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }

    public Product() {
        this.uuid = IdGenerator.generate(this.getClass().getSimpleName().toLowerCase());
    }
}
