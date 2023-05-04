package com.learning;

import com.learning.enums.CardLevel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Auther: zuowenzhi 2023/3/2 created
 * @Description: com.learning
 * @version: 1.0
 */
@Data
public class Student {
    private String name ;
    private String clazz;
    private Integer age;
    private LocalDateTime birthday;
    private CardLevel cardLevel;
}


