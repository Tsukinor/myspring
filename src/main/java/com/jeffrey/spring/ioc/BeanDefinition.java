package com.jeffrey.spring.ioc;

/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-17 21:00
 * @description:
 * BeanDefinition 用于封装/记录Bean的信息
 *  {1.scope 2.bean对应的Class对象，反射可以生成对应的对象}
 **/
public class BeanDefinition {
    private String scope;
    private Class clazz;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "BeanDefinition{" +
                "scope='" + scope + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
