package com.juan.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.juan.springboot.di.app.springboot_di.models.Product;

//@Primary
@Repository
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product("Product Foo", 100.0, UUID.randomUUID()));
    }

    @Override
    public Product findById(String id) {
        return new Product("Product Foo", 100.0, UUID.fromString(id));
    }

}
