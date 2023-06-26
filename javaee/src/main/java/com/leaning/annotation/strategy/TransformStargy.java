package com.leaning.annotation.strategy;


/**
 * @author dongjimin
 * @description: 策略类统一实现接口
 */
public interface TransformStargy<T> {

    /**
     * 加强实现 -- 实际脱敏规则
     * @param args 脱敏参数
     * @return
     */
    T transFrom(T args);
}
