/*
 * 系统名称:  新一代支付系统天禄项目
 * 子系统名： tianlu-cmp
 * 模块名称： tianlu-cmp-types
 * 文件名称： StockStatus.java
 * 创建人：   28423
 * Copyright (c) 2022-2023,  All Rights Reserved.
 * 所有版权归易生支付有限公司所有
 *
 *
 * 注意： 本内容仅限于易生支付有限公司内部使用，禁止转发
 */

package com.learning.enums;

import java.util.Arrays;

/**
 * @author
 * 卡片等级
 */
public enum CardLevel {
    /**PRIMARY:普通*/
    PRIMARY("1","普通");

    private String value;
    private String desc;

    private CardLevel(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return this.value;
    }

    public static CardLevel valuesOf(String value) {
        return Arrays.stream(CardLevel.values()).filter(s->s.value == value).findFirst().get();
    }
}
