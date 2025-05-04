package com.juan.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.juan.springboot.di.app.springboot_di.models.Product;

//@Primary
@Repository
public class ProductRepositoryImpl implements ProductRepository {

   private List<Product> data;

   public ProductRepositoryImpl() {
    this.data = Arrays.asList(
        new Product("Product 1", 100.0, UUID.randomUUID()),
        new Product("Product 2", 200.0, UUID.randomUUID() ),
        new Product("Product 3", 300.0, UUID.randomUUID() ),
        new Product("Product 4", 400.0, UUID.randomUUID()),
        new Product("Product 5", 500.0, UUID.randomUUID() )
    );
   }

   @Override
   public List<Product> findAll() {
       return this.data;
   }

   @Override
   public Product findById(String id) {
       return this.data.stream()
              .filter(p -> p.getId().toString().equals(id))
              .findFirst()
              .orElse(null);
   }
   
}
