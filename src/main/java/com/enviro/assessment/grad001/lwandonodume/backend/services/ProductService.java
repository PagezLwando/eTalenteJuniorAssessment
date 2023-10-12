package com.enviro.assessment.grad001.lwandonodume.backend.services;

import com.enviro.assessment.grad001.lwandonodume.backend.models.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    Product findById(Long id);

    List<Product> findAllProducts();
}