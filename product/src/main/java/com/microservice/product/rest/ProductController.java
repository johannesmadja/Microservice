package com.microservice.product.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.product.database.ProductDto;
import com.microservice.product.database.domain.Product;
import com.microservice.product.database.mapping.ProductMapper;
import com.microservice.product.services.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(
        ProductService productService,
        ProductMapper productMapper
    ) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(productMapper.mapEntityToList(productService.geProducts()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable String id) {
        return ResponseEntity.ok(productMapper.maProductDto(productService.getProduct(id)));
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto) {
        log.info("Enrégistrement du Product: {}", productDto);
        Product savedProduct = productService.saveProduct(productDto);

        Product existingProduct = productService.getProduct(savedProduct.getUuid());
        if (existingProduct != null) {
            return ResponseEntity.ok("Product created successfully");
            // URI location = URI.create("/products/" + savedProduct.getUuid());
            // return ResponseEntity.created(location).build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody Product product) {
        productService.updateProduct(product);
        return ResponseEntity.ok("Product updated successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@PathVariable String uuid) {
        productService.deleteProduct(uuid);
        return ResponseEntity.ok("Product deleted successfully");
    }

}
