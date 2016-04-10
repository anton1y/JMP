package com.epam.training.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.training.model.Product;

public class ProductRepositoryImpl implements ProductRepository {
    private long sequence = 0;

    private final Map<Long, Product> register = new HashMap<Long, Product>();

    @Override
    public Product getProductById(Long productId) {
        return register.get(productId);
    }

    @Override
    public List<Product> getProducts() {
       return new ArrayList<Product>(register.values());
    }

    @Override
    public List<Product> getProductsByName(String name) {
        List<Product> filterProduct = new ArrayList<Product>();
        for (Product product : register.values()) {
            if (product.getName().equals(name)) {
                filterProduct.add(product);
            }
        }
        return filterProduct;
    }

    @Override
    public Long createProduct(Product product) {
        product.setId(++sequence);
        register.put(sequence, product);
        return sequence;
    }

    @Override
    public void updateProduct(Product product) {
        if (product.getId() != null) {
            register.put(product.getId(), product);
        }

    }

    @Override
    public void deleteProduct(Long productId) {
        register.remove(productId);

    }

}
