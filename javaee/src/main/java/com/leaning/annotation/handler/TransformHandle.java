
package com.leaning.annotation.handler;


import com.leaning.annotation.strategy.TransformStargy;

/**
 * @author dongjimin
 * @description: 脱敏策略调度类
 */
public interface TransformHandle {
    <T> Object excute(T source, TransformStargy stargy);
}
