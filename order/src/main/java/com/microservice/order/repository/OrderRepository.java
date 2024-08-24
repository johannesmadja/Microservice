package com.microservice.order.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservice.order.database.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    @Modifying
    @Query("update Order o set o.orderPaid = true where o.uuid = :id")
    void update(@Param("id") String id);
}
