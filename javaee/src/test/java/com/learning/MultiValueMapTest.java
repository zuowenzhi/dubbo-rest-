package com.learning;

import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.List;

/**
 * @author: zuowenzhi 2023/6/26 created
 * @Description: com.learning
 * @version: 1.0
 */

public class MultiValueMapTest {
    public static void main(String[] args) {
//        MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap<>();
//        multiValueMap.add("a","1");
//        multiValueMap.add("a","2");
//        multiValueMap.add("a","3");
//
//        List<String> values = multiValueMap.get("a");
//        System.out.println(values);
//
        String a = "1213";
        String[] split = a.split(",");
        System.out.println(Arrays.asList(split));

    }
}


