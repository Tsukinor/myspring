package com.jeffrey.spring.component;

/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-20 14:04
 * @description:
 **/


public class SmartAnimalAspect {
    public static void showBeginLog(){
        System.out.println("前置通知.....");
    }
    public static void showAfterLog(){
        System.out.println("返回通知.....");
    }


}
