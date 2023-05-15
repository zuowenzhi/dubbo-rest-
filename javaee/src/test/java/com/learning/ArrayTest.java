package com.learning;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;

/**
 * @author: zuowenzhi 2023/5/10 created
 * @Description: com.learning
 * @version: 1.0
 */

public class ArrayTest {
    @Test
    public void test(){
        int[] arr = new int[10];
        System.out.println(arr.length);
        String format = MessageFormat.format("msg", "msg1");
        System.out.println(format);
    }
}


