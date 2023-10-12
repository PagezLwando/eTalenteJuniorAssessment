package com.enviro.assessment.grad001.lwandonodume.backend.services.Impl;

import com.enviro.assessment.grad001.lwandonodume.backend.exceptions.AgeException;
import com.enviro.assessment.grad001.lwandonodume.backend.models.Investor;
import com.enviro.assessment.grad001.lwandonodume.backend.models.Product;
import com.enviro.assessment.grad001.lwandonodume.backend.models.Type;
import com.enviro.assessment.grad001.lwandonodume.backend.repository.ProductRepository;
import com.enviro.assessment.grad001.lwandonodume.backend.services.InvestorService;
import com.enviro.assessment.grad001.lwandonodume.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    InvestorService investorService;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product save(Product product){
        Investor investor = investorService.findById(product.getInvestorId());
        int age = calculateAge(investor.getDateOfBirth());
        try {
            if (product.getType().equals(Type.RETIREMENT) && age >= 65) {
                throw new AgeException("Age must be less than or equal to 65.");
            }
        } catch (Exception e) {
            System.err.println("Unexpected exception: " + e.getMessage());
        }
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    private int calculateAge(LocalDate dateOfBirth) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(dateOfBirth, now);
        return period.getYears();
    }
}