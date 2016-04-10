package com.epam.training.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epam.training.repository.ProductRepository;
import com.epam.training.service.ProductService;
import com.epam.training.service.ProductServiceImpl;

@Configuration
public class ServiceConfig {
    @Autowired
    private ProductRepository productRepository;

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl(productRepository);
    }
}
