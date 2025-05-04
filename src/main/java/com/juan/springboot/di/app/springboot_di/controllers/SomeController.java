package com.juan.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.juan.springboot.di.app.springboot_di.models.Product;
import com.juan.springboot.di.app.springboot_di.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    private ProductService productService ;

    @GetMapping
    public List<Product> list(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable String id) {
        return productService.findById(id);
    }
    

}
