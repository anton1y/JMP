package jmp.spring.mvc.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jmp.spring.core.entities.Customer;
import jmp.spring.core.services.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger logger = Logger.getLogger(CustomerController.class);

    public CustomerController() {
        System.out.println("CustomerController()");
    }

    @Autowired
    UserActivity userActivity;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAllCustomers() {
        logger.info("Getting the all Customers.");
        userActivity.addActivity("Get All Users");
        List<Customer> customerList = customerService.findAll();
        return new ModelAndView("customers", "customerList", customerList);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Alternates=specialTemplate")
    public ModelAndView showCustomersSpecialTemplate() {
        logger.info("Getting the all Customers with the spetial template.");
        userActivity.addActivity("Get All Users with the spetial template.");
        List<Customer> customerList = customerService.findAll();
        return new ModelAndView("customersSpetial", "customerList", customerList);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editCustomer(@PathVariable("id") long id) {
        logger.info("Updating the Customer for the Id " + id);
        userActivity.addActivity("Edit user with Id = " + id);
        Customer customer = customerService.getCustomer(id);
        return new ModelAndView("customerForm", "customer", customer);
    }
    
    @RequestMapping(value = "/add/", method = RequestMethod.GET)
    public ModelAndView editCustomer(@ModelAttribute Customer Customer) {
        logger.info("Adding the Customer");
        userActivity.addActivity("Add customer");
        Customer customer = new Customer();
        return new ModelAndView("customerForm", "customer", customer);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable("id") long id, @ModelAttribute Customer Customer) {
        logger.info("Deleting the Customer for the Id " + id);
        userActivity.addActivity("delete user with Id = " + id);
        customerService.deleteCustomer(id);
        return new ModelAndView("redirect:/customers/");
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public ModelAndView saveCustomer(@ModelAttribute Customer customer) {
        logger.info("Saving the Customer. Data : " + customer);
        userActivity.addActivity("Save user with Id = " + customer.getId());
        customerService.saveCustomer(customer);
        return new ModelAndView("redirect:/customers/");
    }

}