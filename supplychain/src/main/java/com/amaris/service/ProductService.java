package com.amaris.service;

import com.amaris.exception.ProductNotFoundException;
import com.amaris.model.Product;
import com.amaris.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List getProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow( ()-> new ProductNotFoundException("Product by id " + id + " was not found!"));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
