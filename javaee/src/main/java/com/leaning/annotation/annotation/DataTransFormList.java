package com.leaning.annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义需要敏感数据脱敏或数据加密的List
 * @author
 */
@Retention(RetentionPolicy.RUNTIME)

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface DataTransFormList {
}
