package com.learning;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * @Auther: zuowenzhi 2023/3/2 created
 * @Description: com.learning
 * @version: 1.0
 */

public class MapStructTest {


    @Test
    public void test() {
        Student student = new Student();
        student.setName("name");
        StudentDto converter = StudentConverter.INSTANCE.converter(student, "地址信息", LocalDateTime.now());
        System.out.println(converter);
    }

    @Test
    public void test2() {
//        int count=10;
//        for (int i = 0; i < count; i++) {
//            String s =
//            System.out.println(s);
//        }
        for (int i = 0; i < 1000; i++) {
//            String valueOf = String.valueOf(random.nextInt(1000000));
            String valueOf = RandomUtil.randomNumbers(6);
            System.out.println(valueOf);
            if (valueOf.length() < 6) {
                System.out.println("==============" + valueOf + "   " + i);
                break;
            }
        }

    }

    @Test
    public void test4() {
        // 自定义纯数字的验证码（随机4位数字，可重复）
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 6);
        for (int i = 0; i < 1000; i++) {
            String generate = randomGenerator.generate();
            System.out.println(generate);
            if (generate.length() < 6) {
                System.out.println("==============" + generate + "   " + i);
                break;
            }

        }

//        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
//        lineCaptcha.setGenerator(randomGenerator);
//// 重新生成code
//        lineCaptcha.createCode();
//        String code = lineCaptcha.getCode();
//        System.out.println(code);
    }
}


