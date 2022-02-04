package com.amaris.config;

import com.amaris.model.Product;
import com.amaris.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            Product product1 = new Product(1L, "Rice", 1.5, 6);
            Product product2 = new Product(2L, "Bread", 09.0, 12);
            Product product3 = new Product(3L, "Milk", 1.10, 20);
            Product product4 = new Product(4L, "Chocolate", 1.30, 15);
            Product product5 = new Product(5L, "Fish", 5.50, 18);
            productRepository.saveAll(List.of(product1, product2, product3, product4, product5));
        };
    }
}
