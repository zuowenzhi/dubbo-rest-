package com.leaning.annotation.annotation;

/**
 * 定义需要敏感数据脱敏或数据加密的类
 * @author
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface DataTransFormClass {
}
