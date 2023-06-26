package com.leaning.annotation.handler;

import com.leaning.annotation.strategy.TransformStargy;
import org.springframework.stereotype.Service;

/**
 * @author: dongjimin
 * @description: 策略调度实现
 */
@Service
public class TransformHandleImpl implements TransformHandle {
    @Override
    public <T> Object excute(T source, TransformStargy stargy) {
        return stargy.transFrom(source);
    }
}
