

package com.leaning.enums;

import java.util.Arrays;

/**
 * 是否
 */
public enum YesNo {
    YES("1","是"),
    NO("0","否");

    private String value;
    private String desc;

    private YesNo(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return this.value;
    }

    public static YesNo valuesOf(String value) {
        return Arrays.stream(YesNo.values()).filter(s->s.value == value).findFirst().get();
    }
}
