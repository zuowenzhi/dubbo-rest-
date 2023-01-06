/*
 * 系统名称:  新一代支付系统天禄项目
 * 子系统名： tianlu-cmp
 * 模块名称： tianlu-cmp-domain
 * 文件名称： LogStatus.java
 * 创建人：   jsh.li
 * Copyright (c) 2022-2022,  All Rights Reserved.
 * 所有版权归易生支付有限公司所有
 *
 *
 * 注意： 本内容仅限于易生支付有限公司内部使用，禁止转发
 */

package com.leaning.stream;

import java.util.Arrays;
import java.util.Optional;


public enum LogStatus {
    FIRST(1,"一"),
    SECOND(2,"二"),
    THIRD(3,"三")
    ;
    private Integer value;
    private String desc;
    private LogStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return this.value;
    }

    public static LogStatus valuesOf(int value) {
        Optional<LogStatus> first = Arrays.stream(LogStatus.values()).filter(s -> s.value == value).findFirst();

        return first.get();
    }

}
