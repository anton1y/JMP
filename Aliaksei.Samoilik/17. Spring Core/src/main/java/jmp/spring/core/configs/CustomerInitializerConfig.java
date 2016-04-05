package jmp.spring.core.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jmp.spring.core.CustomerInitializer;
import jmp.spring.core.services.CustomerService;

@Configuration
public class CustomerInitializerConfig {
    @Autowired
    CustomerService customerService;

    @Bean(initMethod = "init")
    public CustomerInitializer dataInitializer() {
        CustomerInitializer productInitializer = new CustomerInitializer();
        productInitializer.setCustomerService(customerService);
        return productInitializer;
    }
}
