package jmp.spring.core;

import java.util.ArrayList;
import java.util.List;

import jmp.spring.core.entities.Customer;
import jmp.spring.core.services.CustomerService;

public class CustomerInitializer {

    CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void init() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Jack", "Bauer"));
        customers.add(new Customer("Chloe", "O'Brian"));
        customers.add(new Customer("Kim", "Bauer"));
        customers.add(new Customer("Michelle", "Dessler"));
        customerService.initCustomers(customers);
    }
}

