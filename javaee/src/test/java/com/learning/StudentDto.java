package com.learning;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Auther: zuowenzhi 2023/3/2 created
 * @Description: com.learning
 * @version: 1.0
 */

@Data
public class StudentDto {
    private String name ;
    private String clazz;
    private String address;
    private Integer age;
    private LocalDateTime birthday;
    public String cardLevel;
}


