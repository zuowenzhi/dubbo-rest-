package com.leaning.util;

/**
 * @author: zuowenzhi 2023/6/14 created
 * @Description: com.leaning.util
 * @version: 1.0
 */

public class TestUtil {

    public static boolean checkRangeLength(String cardRange,String cardNoLength) {
        return "16".equals(cardNoLength)?cardRange.length()==5:cardRange.length()==8;
    }

    public static String int2Str(Integer cardRangeInt, String cardNoLength) {
        return String.format(format(Integer.parseInt(cardNoLength)-11),cardRangeInt);
    }

    private static String format(int length){
        return "%0"+length+"d";
    }
}


