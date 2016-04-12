package com.epam.training.service;

import java.util.List;

import com.epam.training.model.Product;
import com.epam.training.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Product getProductById(Long productId) {

        return repository.getProductById(productId);
    }

    @Override
    public List<Product> getProducts() {
        return repository.getProducts();
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return repository.getProductsByName(name);
    }

    @Override
    public Long createProduct(Product product) {
        return repository.createProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        repository.updateProduct(product);

    }

    @Override
    public void deleteProduct(Long productId) {
        repository.deleteProduct(productId);

    }

}
