package com.leaning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: zuowenzhi 2022/12/28 created
 * @Description: com.leaning
 * @version: 1.0
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.leaning"})
public class DubboSpringConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboSpringConsumerApplication.class, args);
    }
}


