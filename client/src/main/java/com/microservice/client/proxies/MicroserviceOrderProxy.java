package com.microservice.client.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.client.beans.OrderBean;

@FeignClient(name = "microservice-order", url = "http://localhost:8002")
public interface MicroserviceOrderProxy {

    /**
     * Retrieves an OrderBean object based on the provided order ID.
     *
     * @param id    the ID of the order to be retrieved
     * @return      the OrderBean object associated with the given ID
     */
    @GetMapping(value = "/order/{id}")
    OrderBean getOrder(@PathVariable("id") String id);

    @PostMapping
    OrderBean createOrder(@RequestBody OrderBean orderBean);

    @PutMapping("/{id}")
    ResponseEntity<Object> updateOrder(@PathVariable("id") String id);

    
}
