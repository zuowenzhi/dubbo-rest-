package com.learning;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.leaning.enums.YesNo;
import com.leaning.util.NumberUtil;
import com.leaning.util.TestUtil;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

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

    @Test
    public void testRegix(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
//        String regex = "[0,1]{1}";
//        String num = "b";
//
//        System.out.println(num.matches(regex));
    }

    @Test
    public void strReplace(){
        String s = DesensitizedUtil.mobilePhone("18612345678");
        String name = "左文智的";
        String replace = StrUtil.replace("15877656545", 3, 7, '*');
        String replace2 = StrUtil.replace(name, 1, name.length(), '*');
        System.out.println(replace);
        System.out.println(replace2);
        System.out.println(s);
    }

    @Test
    public void testLIstSize(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("1");
        strings.add("1");
        System.out.println(strings.toString().length());
    }

    @Test
    public void test8(){
        Instant instant = new Date().toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(instant+"----"+zoneId);
        LocalDateTime localBillDateTime = LocalDateTime.ofInstant(instant,zoneId);
        System.out.println(localBillDateTime);
    }

    @Test
    public void test10(){
        for (int i = 0; i < 10; i++) {
//            System.out.println(NumberUtil.genRandomIntNumber6());
            System.out.println(RandomUtil.randomNumbers(6));
        }
    }

    @Test
    public void testRange(){
        System.out.println(TestUtil.checkRangeLength("10001", "19"));
    }

    @Test
    public void testLength(){
        String regex="^(?!0{5,8}$)\\d{5}(\\d{3})?$";
        String number= "00000";
        System.out.println(number.matches(regex));
    }

}


