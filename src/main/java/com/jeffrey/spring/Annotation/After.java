package com.jeffrey.spring.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-20 14:50
 * @description:
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface After {
    String value();

    String argNames() default "";
}

