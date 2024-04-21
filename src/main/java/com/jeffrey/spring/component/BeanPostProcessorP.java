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

        //这里请小伙伴一定要体会到，后置处理器是会容器的创建的bean生效
        //，相当于是可以对多个对象编程， 切面编程
        //日志，权限，身份, 事务.......
        if (bean instanceof Car) {
            System.out.println("这是一个Car对象, 我可以处理");
            //((Car)bean)
        }

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
                                SmartAnimalAspect.showSuccessLog();
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
