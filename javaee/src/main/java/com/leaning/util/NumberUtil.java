package com.leaning.util;

import java.security.SecureRandom;

public class NumberUtil {

    public static String genRandomIntNumber6(){
        SecureRandom random=new SecureRandom();
        return String.valueOf(random.nextInt(1000000));
    }
}


