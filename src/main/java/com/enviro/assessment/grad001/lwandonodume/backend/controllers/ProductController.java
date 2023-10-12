package com.enviro.assessment.grad001.lwandonodume.backend.controllers;

import com.enviro.assessment.grad001.lwandonodume.backend.models.Product;
import com.enviro.assessment.grad001.lwandonodume.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/v1")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/post")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping(path = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product =  productService.findById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
