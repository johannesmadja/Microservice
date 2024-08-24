package com.microservice.client.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.client.beans.PaymentBean;

@FeignClient(name = "microservice-payments", url = "http://localhost:8003")
public interface MicroservicePaymentProxy {

    @PostMapping
    ResponseEntity<PaymentBean> createPayment(@RequestBody PaymentBean paymentBean);

}
