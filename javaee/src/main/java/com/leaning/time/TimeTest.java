package com.leaning.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author: zuowenzhi 2023/5/4 created
 * @Description: com.leaning.time
 * @version: 1.0
 */

public class TimeTest {


    @Test
    public void test(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.with(LocalTime.MIN));
    }
}


