package com.epam.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.epam.training.model.Product;
import com.epam.training.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showProducts() {
        ModelAndView model = new ModelAndView("products");
        List<Product> productsList = productService.getProducts();
        model.addObject("products", productsList);

        return model;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, headers ="Alternates=specialTemplate")
    public ModelAndView showProductsSpecialTemplate() {
        ModelAndView model = new ModelAndView("productsSpecial");
        List<Product> productsList = productService.getProducts();
        model.addObject("products", productsList);

        return model;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, headers ="Alternates=superSpecialTemplate")
    public ModelAndView showProductsSuperSpecialTemplate() {
        ModelAndView model = new ModelAndView("superProductsSpecial");
        List<Product> productsList = productService.getProducts();
        model.addObject("products", productsList);

        return model;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView showProduct(@PathVariable("id") Long id,HttpServletRequest request) {
        
        ModelAndView model = new ModelAndView("product");
        Product product = productService.getProductById(id);
        model.addObject("product", product);
        HttpSession session = request.getSession();
        session.setAttribute("lastProductSelection", product.getId());
        return model;
    }

    @RequestMapping(value = "/createForm", method = RequestMethod.POST)
    public RedirectView createProduct(@ModelAttribute("product") Product product, BindingResult bindingResult) {
        logger.info("Create product " + product);
        productService.createProduct(product);
        RedirectView redView = new RedirectView("/training");
        return redView;
    }

    @RequestMapping(value = "/createForm", method = RequestMethod.GET)
    public ModelAndView createProductForm() {
        ModelAndView model = new ModelAndView("create");
        Product product = new Product();
        model.addObject("product", product);
        return model;
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    public RedirectView deleteproduct(@PathVariable("id") Long id, HttpServletRequest request) {
        request.getSession().removeAttribute("lastProductSelection");
        logger.info("deleteProduct id:", id);
        productService.deleteProduct(id);
        RedirectView redView = new RedirectView("/training");
        return redView;

    }

}
