package jmp.spring.core;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jmp.spring.core.configs.CustomerInitializerConfig;
import jmp.spring.core.configs.RepositoryConfig;
import jmp.spring.core.configs.ServiceConfig;
import jmp.spring.core.entities.Customer;
import jmp.spring.core.services.CustomerService;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(RepositoryConfig.class, ServiceConfig.class,
                CustomerInitializerConfig.class);

        CustomerService customerService = context.getBean(CustomerService.class);

        List<Customer> customers = customerService.findCustomer("Bauer");

        System.out.println(customers);

        ((ConfigurableApplicationContext) context).close();
    }
}
