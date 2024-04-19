package com.jeffrey;

import com.jeffrey.spring.ioc.SpringApplicationP;
import com.jeffrey.spring.ioc.SpringConfig;

/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-17 15:07
 * @description:
 **/
public class AppMain {
    public static void main(String[] args) {
        SpringApplicationP ioc = new SpringApplicationP(SpringConfig.class);

        Object xxx1 = ioc.getBean("monsterService");
        Object xxx2 = ioc.getBean("monsterService");
        Object xxx3 = ioc.getBean("monsterDao");
        Object xxx4 = ioc.getBean("monsterDao");

        System.out.println(xxx1);
        System.out.println(xxx2);
        System.out.println(xxx3);
        System.out.println(xxx4);
        System.out.println("ok");
    }
}
