package jmp.spring.core.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jmp.spring.core.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
