package com.jeffrey.spring.processor;


import com.jeffrey.spring.Annotation.Component;

/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-20 13:08
 * @description:
 **/
public interface BeanPostProcessor {

    default Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {

        return bean;
    }


    default Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
}
