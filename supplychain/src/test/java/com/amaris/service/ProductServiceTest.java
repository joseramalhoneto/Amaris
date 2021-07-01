package com.amaris.service;

import com.amaris.model.Product;
import com.amaris.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void getProductsTest() {
        //when
        productService.getProducts();
        //then
        verify(productRepository).findAll();
    }

    @Test
    void saveProductTest() {
        //given
        Product product = new Product(1L, "Rice", 1.5, 6);
        //when
        productService.saveProduct(product);

        //then
        ArgumentCaptor<Product> argumentCaptor =
                ArgumentCaptor.forClass(Product.class);

        verify(productRepository)
                .save(argumentCaptor.capture());
    }

}