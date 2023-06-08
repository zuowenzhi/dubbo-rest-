package com.learning;

import cn.hutool.core.util.DesensitizedUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: zuowenzhi 2023/5/15 created
 * @Description: com.learning
 * @version: 1.0
 * Optional类的使用
 */

public class OptionalTest {

    @Test
    public void test(){

        List<Student> objects = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        students.add(new Student("张三",20));
        students.add(new Student("李四",21));
        students.add(new Student("赵四",30));
        Student student = new Student("赵四", 30);
        //ofNullable方法:如果为null,返回empty,如果不为null,返回原对象的optional包装类
        //ifPresent,如果创建的Optional中的值存在，则执行该方法的调用，否则什么也不做
        Optional.ofNullable(students).ifPresent(objects::addAll);
        Optional.ofNullable(student).ifPresent(objects::add);
        System.out.println(objects);
    }
}


