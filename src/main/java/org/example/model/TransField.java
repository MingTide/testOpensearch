package com.medaxis.srp.rule.domain.mdr.annotation;

import java.lang.annotation.*;

/**
 * 字段翻译注解
 * @author konglu
 * @date 2024/8/21
 */
@Target({ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TransField {

    String value() default "";
}
