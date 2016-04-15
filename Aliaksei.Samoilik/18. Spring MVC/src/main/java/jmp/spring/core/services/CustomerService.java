package jmp.spring.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.spring.core.entities.Customer;
import jmp.spring.core.repositories.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findCustomer(String lastName) {
        return customerRepository.findByLastName(lastName);
    }
    
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(long id){
        return customerRepository.findOne(id);
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(long id){
        customerRepository.delete(id);
    }

    public void initCustomers(List<Customer> customers) {
        customers.stream().forEach(customer -> customerRepository.save(customer));
    }
}
