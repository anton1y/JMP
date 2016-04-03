package com.epam.training;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.training.config.LauncherConfig;
import com.epam.training.model.Product;
import com.epam.training.service.ProductService;

@SpringBootApplication
public class Launcher {

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(LauncherConfig.class);
        ProductService productService = context.getBean(ProductService.class);

        Product galaxy = productService.getProductsByName("Samsung Galaxy Tab").get(0);
        System.out.println(galaxy);
        Product prestigio = new Product();
        prestigio.setName("Prestigio x32R");
        prestigio.setDescription("16GB, Wi-Fi");
        productService.createProduct(prestigio);
        productService.deleteProduct(galaxy.getId());
        List<Product> productLists = productService.getProducts();
        for (Product product : productLists) {
            System.out.println(product);
        }
    }
}
