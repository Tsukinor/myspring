package com.jeffrey.spring.component;

import com.jeffrey.spring.Annotation.Component;
import com.jeffrey.spring.processor.InitializingBean;

/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-17 15:35
 * @description:
 **/
@Component
public class Car implements InitializingBean {

    @Override
    public void afterPropertiesSet() {
        System.out.println("car -----");
    }
}
