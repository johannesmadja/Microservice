package com.microservice.payment.web;

import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.payment.database.domain.Payment;
import com.microservice.payment.database.dto.PaymentDto;
import com.microservice.payment.database.mapping.PaymentMapper;
import com.microservice.payment.services.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    public PaymentController(
        PaymentService paymentService,
        PaymentMapper paymentMapper
    ){
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @PostMapping
    public ResponseEntity<Object> createPayment(Payment payment) {

        Payment savedPayment = paymentService.createPayment(payment);
        if (savedPayment != null) {
            return new ResponseEntity<>(this.paymentMapper.mPayamentDto(savedPayment), HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().body("La commande avec l'identifiant " + payment.getOrderId().getUuid() + " est introuvable");
    }
}
