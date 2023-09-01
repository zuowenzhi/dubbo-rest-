package com.learning;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.leaning.enums.YesNo;
import com.leaning.stream.CardStatus;
import com.leaning.util.LuhnUtils;
import com.leaning.util.NumberUtil;
import com.leaning.util.TestUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
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
        String phone="^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))([0-1]?[0-9]|2[0-3])([0-5][0-9])([0-5][0-9])$";
        String a="20230711111848";
        boolean matches = a.matches(phone);
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
//        String regex="^(?!0{5,8}$)\\d{5}(\\d{3})?$";
        String regex="^\\d+$";
        String number= "00000";
        System.out.println(number.matches(regex));
    }

    @Test
    public void testLengthFormat(){

        System.out.println(String.format("%99d", 0));
        String s = MessageFormat.format("测试{0}数据", "阿斯顿发斯蒂芬");
        System.out.println(s); // 输出: "测试阿斯顿发斯蒂芬"
    }


    @Test
    public void testMath(){
        int abs = Math.abs(1);
        System.out.println(abs);
    }

    @Test
    public void teststrUtil(){
        String cardNo= "6236681234100615";
        int len = cardNo.length();
        String cardPadding= StrUtil.fill(cardNo.substring(0,6),'*',9,false);
        String substring = cardNo.substring(len - 4);
        System.out.println(String.format("%s%s", cardPadding, substring));


        String str = "Hello";
        int targetLength = 10;

        // 在字符串左侧填充指定字符到目标长度
        String filledStrLeft = StrUtil.fill(str,  '!',targetLength,false);
        System.out.println(filledStrLeft); // Output: !!!!!Hello
//
//        // 在字符串右侧填充指定字符到目标长度
//        String filledStrRight = StrUtil.fillAfter(str, targetLength, '#');
//        System.out.println(filledStrRight); // Output: Hello#####
//
//        // 在字符串两侧填充指定字符到目标长度
//        String filledStrBoth = StrUtil.fillBoth(str, targetLength, '*');
//        System.out.println(filledStrBoth); // Output: **Hello***
//
//        // 在字符串左侧填充指定字符到目标长度，且保留原字符串的右侧字符
//        String filledStrLeftPreserve = StrUtil.fillBeforePreserve(str, targetLength, '^');
//        System.out.println(filledStrLeftPreserve); // Output: ^^Hello
//
//        // 在字符串右侧填充指定字符到目标长度，且保留原字符串的左侧字符
//        String filledStrRightPreserve = StrUtil.fillAfterPreserve(str, targetLength, '&');
//        System.out.println(filledStrRightPreserve); // Output: Hello&&&&&&&
//
//        // 在字符串两侧填充指定字符到目标长度，且保留原字符串的左右字符
//        String filledStrBothPreserve = StrUtil.fillBothPreserve(str, targetLength, '$');
//        System.out.println(filledStrBothPreserve); // Output: $$Hello$$$
    }


    @Test
    public void testPwd(){
        String strHex = Long.toHexString(System.currentTimeMillis());
        String rand= RandomStringUtils.randomAlphanumeric(1)+strHex.substring(strHex.length()-6,strHex.length())+RandomStringUtils.randomAlphanumeric(9);
        System.out.println(rand);//Z5965cfsU72CKYuY  Q546eb2R3xxtsfTY
    }

    @Test
    public void testToken(){
        /*
        * card_token_start 是个6位数字
        * token规则：card_token_start+（卡号长度-card_token_start-1）随机数+1校验位
        * */
        String cardToken = genToken("283713", "16");
        System.out.println(cardToken);//2837135598181013
    }

    private String genToken(String cardTokenStart,String cardNoLen){
        int randomLen = Integer.parseInt(cardNoLen)-cardTokenStart.length()-1;
        String randomNumber = RandomUtil.randomNumbers(randomLen);
        String a= cardTokenStart + randomNumber;
        String b= cardTokenStart.concat(randomNumber);
        int i = LuhnUtils.generateCheckDigit(a);
        int j = LuhnUtils.generateCheckDigit(b);
        System.out.println(j);
        return String.format("%s%s%s",cardTokenStart,randomNumber,i);
    }


    @Test
    public void testEnum(){
        CardStatus[] values = CardStatus.values();
        Arrays.stream(values).forEach(status-> System.out.println(status));
    }


}


