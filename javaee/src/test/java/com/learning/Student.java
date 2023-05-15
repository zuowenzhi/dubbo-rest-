package com.learning;

import com.learning.enums.CardLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Auther: zuowenzhi 2023/3/2 created
 * @Description: com.learning
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Cloneable{
    private String name ;
    private String clazz;
    private Integer age;
    private LocalDateTime birthday;
    private CardLevel cardLevel;

    public Student(String name,  Integer age) {
        this.name = name;
        this.age = age;
    }
}


