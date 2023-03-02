package com.leaning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.leaning"})
public class DubboSpringProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboSpringProviderApplication.class, args);
    }
}