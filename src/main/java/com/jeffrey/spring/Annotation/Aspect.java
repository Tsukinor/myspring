package com.jeffrey.spring.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-20 14:49
 * @description:
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Aspect {
    String value() default "";
}
