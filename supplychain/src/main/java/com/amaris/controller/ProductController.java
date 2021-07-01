package com.amaris.controller;

import com.amaris.model.Product;
import com.amaris.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/supply-chain")
    public ResponseEntity<List<Product>> getProducts(){
        try {
            List products = productService.getProducts();
            if(products == null)
                return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
            else
                return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/supply-chain")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        try {
            Product productResult = productService.saveProduct(product);
            if(productResult == null)
                return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
            else
                return new ResponseEntity<Product>(productResult, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/supply-chain/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        try {
            Product product = productService.findProductById(id);
            if(product == null)
                return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
            else
                return new ResponseEntity<Product>(product, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        try {
            Product productResult = productService.saveProduct(product);
            if(productResult == null)
                return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
            else
                return new ResponseEntity<Product>(productResult, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        try {
            Product product = productService.findProductById(id);
            if(product == null)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            else{
                productService.deleteProduct(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
