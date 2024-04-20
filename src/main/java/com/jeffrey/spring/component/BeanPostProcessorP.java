package com.jeffrey.spring.component;

import com.jeffrey.spring.Annotation.Component;
import com.jeffrey.spring.processor.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-20 13:34
 * @description:
 **/
@Component
public class BeanPostProcessorP implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        System.out.println(" beanPostProcessorP 的前置处理器被调用 "  + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        System.out.println(" beanPostProcessorP 的后置处理器被调用 "  + beanName);

        if ("smartDog".equals(beanName)){
            Object proxyInstance = Proxy.newProxyInstance(this.getClass().getClassLoader(), bean.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args)
                                throws Throwable {
                            System.out.println("method=" + method.getName());
                            //要进行前置处理的方法
                            Object invoke = null;
                            if ("getSum".equals(method.getName())) {
                                SmartAnimalAspect.showBeginLog();
                                invoke = method.invoke(bean, args);//执行目标方法
                                //进行返回通知的处理
                                SmartAnimalAspect.showAfterLog();
                            } else {
                                invoke = method.invoke(bean, args);
                            }
                            return invoke;
                        }
                    });
             return proxyInstance;
        }
        //如果不需要aop，就返回bean
        return bean;
    }
}
