package com.jeffrey.spring.Annotation;

import java.lang.annotation.*;

/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-20 11:26
 * @description:
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {

}
