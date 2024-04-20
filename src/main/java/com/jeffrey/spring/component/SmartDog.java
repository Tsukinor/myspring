package com.jeffrey.spring.component;


import com.jeffrey.spring.Annotation.Component;

/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-15 13:34
 * @description:
 **/
@Component(value = "smartDog")//当spring容器启动时，将该类注入到容器中
public class SmartDog implements SmartAnimalable {
    @Override
    public float getSum(float i, float j) {
         float sum = i + j;
//         int res = 9/0;
        System.out.println("方法内部" + sum);
        return i + j;
    }

    @Override
    public float getSub(float i, float j) {
        float sum = i + j;
        System.out.println("方法内部" + sum);
        return i - j;
    }
}
