package jmp.spring.core.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jmp.spring.core.repositories.CustomerRepository;
import jmp.spring.core.services.CustomerService;

@Configuration
public class ServiceConfig {

    @Autowired
    CustomerRepository customerRepository;
    @Bean
    public CustomerService customerService() {
        CustomerService customerService = new CustomerService();
        customerService.setCustomerRepository(customerRepository);
        return customerService;
    }
}
