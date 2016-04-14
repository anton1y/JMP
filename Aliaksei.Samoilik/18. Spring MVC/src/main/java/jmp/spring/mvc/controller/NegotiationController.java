package jmp.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jmp.spring.core.entities.Customer;
import jmp.spring.core.services.CustomerService;

@RestController
public class NegotiationController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/getCustomers", produces = { "application/xml",
            "application/json" }, method = RequestMethod.GET)
    public @ResponseBody List<Customer> getCustomers() {
        return customerService.findAll();
    }
}
