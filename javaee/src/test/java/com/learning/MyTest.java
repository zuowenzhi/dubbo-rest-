package com.learning;

import cn.hutool.core.date.DatePattern;
import com.leaning.enums.YesNo;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Auther: zuowenzhi 2023/2/7 created
 * @Description: com.learning
 * @version: 1.0
 */

public class MyTest {
    @Test
    public void test(){
        String format = String.format( "%09d", 12);
        System.out.println(format);
    }
    @Test
    public void test4(){

        String a="000031";
        String b="000034";
        System.out.println(a.compareTo(b));
    }

    @Test
    public void test5(){
        YesNo yes = YesNo.YES;
        boolean equals = YesNo.YES.getValue().equals(yes.getValue());
        System.out.println(equals);

    }

    @Test
    public void test6(){
        String re="^(?![0]{8})[0-9]{8}$";
        String a="00000100";
        boolean matches = a.matches(re);
        System.out.println(matches);
    }

    @Test
    public void test7(){
        boolean overlap1 = isOverlap1(21, 30, 11, 20);
        System.out.println(overlap1);
    }
    public boolean isOverlap1(int start1, int end1, int start2, int end2) {
        if (Math.max(start1, start2) <= Math.min(end1, end2)) {
            return true;
        }
        return false;
    }


    public boolean isOverlap(int start1, int end1, int start2, int end2) {
        if (start1 > end2 || start2 > end1) {
            return false;
        }
        return true;
    }
    @Test
    public void test9(){
        int start1=1;
        int end1=200;
        int start2=20;
        int end2=300;
        if (Integer.compare(start2, start1) >= 0 && Integer.compare(end2, end1) <= 0) {
            System.out.println("第二个号段被第一个号段包含");
        } else {
            System.out.println("第二个号段未被第一个号段包含");
        }
    }

    @Test
    public void testDateFormat(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyMM");
        String format = localDateTime.format(df);
        System.out.println(format);
    }

}


