
package com.leaning.util;

/**
 * Luhn算法工具类
 */
public class LuhnUtils {

    /**
     * 将 识别码字符串 根据Luhn算法 计算出 校验码
     * @param digits 识别码字符串
     * @return int 校验码
     */
    public static int generateCheckDigit(String digits) {
        // 返回 校验码
        return generateCheckDigit(strToIntArray(digits));
    }

    /**
     * 将 识别码 根据Luhn算法 计算出 校验码
     * @param digits 识别码字符串数组
     * @return int 校验码
     */
    public static int generateCheckDigit(int[] digits) {
        int sum = 0;
        int length = digits.length;
        // 遍历 识别码字符串数组
        for(int i=0; i<length; i++) {
            // 倒序取得识别码字符串数组中的每一位数字
            int digit = digits[length - i - 1];
            // 判断如果是奇数位(这里i是从0开始，0,2,4...是奇数位)
            if (i % 2 == 0) {
                // 当前位的数字 = 当前位数字 * 2
                digit *= 2;
            }
            // 如果乘积为两位数，十位与个位相加(减去9是更简便方式)
            sum += digit > 9 ? digit - 9 : digit;
        }
        // 返回 模10的补数
        return (10 - sum % 10) % 10;
    }

    /**
     * Luhn算法验证方法
     * @param digits 识别码字符串数组
     * @return boolean 验证结果
     */
    public static boolean check(int[] digits) {
        int sum = 0;
        int length = digits.length;
        // 遍历 识别码字符串数组
        for (int i = 0; i < length; i++) {
            // 倒序取得识别码字符串数组中的每一位数字
            int digit = digits[length - i - 1];
            // 判断如果是偶数位(这里i是从0开始，1,3,5...是偶数位)
            if (i % 2 == 1) {
                // 当前位的数字 = 当前位数字 * 2
                digit *= 2;
            }
            // 如果乘积为两位数，十位与个位相加(减去9是更简便方式)
            sum += digit > 9 ? digit - 9 : digit;
        }
        // 可以被10整除，认定校验通过
        return sum % 10 == 0;
    }

    /**
     * Luhn算法验证方法
     * @param digits 识别码字符串
     * @return boolean 验证结果
     */
    public static boolean check(String digits) {
        // Luhn算法验证方法
        return check(strToIntArray(digits));
    }

    /**
     * 字符串转数组
     * @param digits 识别码字符串
     * @return int[] 识别码字符串数组
     */
    private static int[] strToIntArray(String digits){
        int length = digits.length();
        int[] xInt = new int[length];
        // 将 识别码字符串 转换成 字符数组
        char[] xChar = digits.toCharArray();
        // 遍历 字符数组 生成 识别码字符串数组
        for (int i = 0; i < digits.length(); i++) {
            //效果相同 xInt[i] = Integer.parseInt(String.valueOf(xChar[i]));
            xInt[i] = xChar[i] - 48;
        }
        return xInt;
    }

}
