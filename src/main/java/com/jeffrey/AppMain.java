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
        SpringApplicationP ioc =
                new SpringApplicationP(SpringConfig.class);
    }
}
