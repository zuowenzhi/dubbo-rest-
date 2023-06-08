package com.leaning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: zuowenzhi 2023/6/1 created
 * @Description: com.leaning
 * @version: 1.0
 */

@SpringBootApplication
@MapperScan("com.leaning.statemachine.mapper")
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class);
    }
}


