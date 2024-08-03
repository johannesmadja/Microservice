package com.microservice.product.database.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservice.product.database.domain.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
    @Modifying
    @Query("UPDATE Product p set p.title = :title, p.description = :description, p.image = :image, p.price = :price where p.uuid = :id")
    public void update(
        @Param("id") String id,
        @Param("title") String title,
        @Param("description") String description,
        @Param("image") String image,
        @Param("price") BigDecimal price
    );
}
