package com.jeffrey.spring.component;

import com.jeffrey.spring.Annotation.After;
import com.jeffrey.spring.Annotation.Before;

/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-20 14:04
 * @description:
 **/


public class SmartAnimalAspect {
    @Before(value = "execution com.jeffrey.spring.aop.aspectj.SmartDog getSum")
    public static void showBeginLog() {

        System.out.println("前置通知..");
    }

    @After(value = "execution com.jeffrey.spring.aop.aspectj.SmartDog getSum")
    public static void showSuccessLog() {

        System.out.println("返回通知..");
    }

}
