package com.juan.springboot.di.app.springboot_di.models;

import java.util.UUID;

public class Product implements Cloneable {
    private String name;
    private Double price;
    private UUID id ;

    public Product() {
    }
    
    public Product(String name, Double price, UUID id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public UUID getId() {
        return id;
    }

    @Override
    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Product(this.getName(), this.getPrice(), this.getId());
        }
    }

    

    
}
