package com.microservice.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.payment.database.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String>{

}
