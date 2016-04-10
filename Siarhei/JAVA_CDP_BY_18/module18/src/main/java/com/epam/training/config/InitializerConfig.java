package com.epam.training.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epam.training.initializer.ProductInitializer;
import com.epam.training.service.ProductService;

@Configuration
public class InitializerConfig {
    @Autowired
    private ProductService productService;

    @Bean(initMethod = "initProducts")
    public ProductInitializer dataInitializer() {
        ProductInitializer productInitializer = new ProductInitializer(productService);

        return productInitializer;
    }
}
