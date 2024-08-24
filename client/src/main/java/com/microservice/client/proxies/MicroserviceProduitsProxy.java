package com.microservice.client.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.client.beans.ProductBean;

@FeignClient(name = "microservice-product", url = "http://localhost:8001")
public interface MicroserviceProduitsProxy {

    /**
     * Retrieves a list of products from the microservice 'microservice-product' at 'http://localhost:8001'.
     *
     * @return A list of ProductBean objects representing the products.
     */
    @GetMapping("/products")
    List<ProductBean> getProducts();

    /**
     * Retrieves a product by its unique identifier from the microservice 'microservice-product'.
     *
     * @param  id	Unique identifier of the product
     * @return A ProductBean object representing the product
     */
    @GetMapping("/products/{id}")
    ProductBean getProductByUuid(@PathVariable("id") String id);
}
