package com.epam.training.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epam.training.repository.ProductRepository;
import com.epam.training.repository.ProductRepositoryImpl;

@Configuration
public class RepositoryConfig {
    @Bean
    public ProductRepository productRepository() {
        return new ProductRepositoryImpl();
    }
}
