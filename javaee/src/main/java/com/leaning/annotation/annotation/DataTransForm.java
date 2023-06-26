package com.leaning.annotation.annotation;


import com.leaning.annotation.strategy.IdCardStargy;
import com.leaning.annotation.strategy.TransformStargy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 脱敏加密注释
 * @author
 */
@Retention(RetentionPolicy.RUNTIME)

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface DataTransForm {

    /**
     * 是否脱敏
     */
    boolean isDesensitize() default false;

    /**
     * 是否加密
     */
    boolean isEncipher() default false;

    /**
     * 是否解密
     */
    boolean isDecrypt() default false;

    /**
     * 是否OSSURL转换
     */
    boolean isUrlConvert() default false;

    /**
     * 加密字段保存字段
     */
    String encipherFieldName() default "";

    /**
     * 脱敏策略类
     * @return
     */
    Class<? extends TransformStargy> stargy() default IdCardStargy.class;
}
