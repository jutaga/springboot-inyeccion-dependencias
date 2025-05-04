package com.juan.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juan.springboot.di.app.springboot_di.models.Product;

public class ProductRepositoyJSON implements ProductRepository {

    private List<Product> list;

    public ProductRepositoyJSON() {
        Resource resource = new ClassPathResource("json/product.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            list = Arrays.asList(mapper.readValue(resource.getFile(), Product[].class));
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(String id) {
        return list.stream().filter(p -> p.getId().equals(UUID.fromString(id))).findFirst().orElse(null);
    }

}
