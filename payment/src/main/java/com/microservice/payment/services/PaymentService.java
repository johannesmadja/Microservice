package com.microservice.payment.services;

import org.springframework.stereotype.Service;

import com.microservice.payment.database.domain.Payment;
import com.microservice.payment.repository.PaymentRepository;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(
        PaymentRepository paymentRepository
    ){
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
