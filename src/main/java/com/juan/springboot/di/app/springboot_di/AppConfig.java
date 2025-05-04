package com.juan.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.juan.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.juan.springboot.di.app.springboot_di.repositories.ProductRepositoyJSON;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    @Primary
    ProductRepository productRepositoryJSON() {
        return new ProductRepositoyJSON();
    }

}
