package com.learning;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

/**
 * @Auther: zuowenzhi 2023/3/2 created
 * @Description: com.learning
 * @version: 1.0
 */

public class MapStructTest {


    @Test
    public void test(){
        Student student = new Student();
        student.setName("name");
        StudentDto converter = StudentConverter.INSTANCE.converter(student,"地址信息", LocalDateTime.now());
        System.out.println(converter);
    }
}


