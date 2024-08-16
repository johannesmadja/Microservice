package com.microservice.product.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.product.database.ProductDto;
import com.microservice.product.database.domain.Product;
import com.microservice.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(
        ProductRepository productRepository
    ) {
        this.productRepository = productRepository;
    }

    /*
     * Get product by uuid
     * @Param uuid 
     */
    public Product getProduct(String uuid) {
        return productRepository.findById(uuid).orElse(null);
    }

    /*
     * Get all products
     */
    public List<Product> geProducts() { 
        return productRepository.findAll();
    }

    /*
     * Save product
     */
    public Product saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        product.setPrice(productDto.getPrice());
        
        return productRepository.save(product);
    }

    public void updateProduct(Product product) {
        productRepository.update(product.getUuid(), product.getTitle(), product.getDescription(), product.getImage(), product.getPrice());
    }

    /* 
     * Delete product
    */
    public void deleteProduct(String uuid) {
        productRepository.deleteById(uuid);
    }

}
