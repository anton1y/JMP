package com.epam.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.training.model.Product;
import com.epam.training.service.ProductService;

@Controller
public class ProductRestController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/productReturn", produces = { "application/xml", "application/json" }, method = {
            RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody List<Product> showProducts() {
        return productService.getProducts();
    }
    
    @RequestMapping(value = "/productReturn/{id}", produces = { "application/xml", "application/json" }, method = {
            RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Product showProductsOne(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }
}
