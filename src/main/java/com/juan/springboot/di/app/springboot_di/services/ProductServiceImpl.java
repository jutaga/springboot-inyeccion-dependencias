package com.juan.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.juan.springboot.di.app.springboot_di.models.Product;
import com.juan.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private Environment environment;
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream().map(p -> {
            // Product newProduct = new Product( p.getName(), p.getPrice() * 1.16d,
            // p.getId() );
            // return newProduct;

            Product newProduct = (Product) p.clone();
            newProduct.setPrice(p.getPrice() * environment.getProperty("config.price.tax", Double.class, 1.0d));
            return newProduct;
        }).collect(Collectors.toList());
    };

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

}
