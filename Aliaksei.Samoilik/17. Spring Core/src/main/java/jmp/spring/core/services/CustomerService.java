package jmp.spring.core.services;

import java.util.List;

import jmp.spring.core.entities.Customer;
import jmp.spring.core.repositories.CustomerRepository;

public class CustomerService {

    CustomerRepository customerRepository;

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    public List<Customer> findCustomer(String lastName){
        return customerRepository.findByLastName(lastName);
    }

    public void initCustomers(List<Customer> customers){
        customers.stream().forEach(customer->customerRepository.save(customer));
    }
}
