package com.jeffrey.spring.ioc;

import com.jeffrey.spring.Annotation.Component;
import com.jeffrey.spring.Annotation.ComponentScan;
import com.jeffrey.spring.Annotation.Scope;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-17 15:08
 * @description:
 **/
public class SpringApplicationP {
    private Class target_config;

    //定义beanDefinitionMap --》存放 BeanDefinition 对象
    public ConcurrentHashMap<String,BeanDefinition> beanDefinitionMap =
            new ConcurrentHashMap<>();

    //定义singletonObjects --》 存放 单例对象
    public ConcurrentHashMap<String,Object> singletonObjects =
            new ConcurrentHashMap<>();
    public SpringApplicationP(Class target_config){
        beanDefinitionScan(target_config);
        System.out.println(beanDefinitionMap);
    }

    //该方法完成对指定包的扫描，并将Bean信息封装到BeanDefinitionMap中
    public void beanDefinitionScan(Class target_config){

        this.target_config = target_config;

        //得到该配置类注解，获取包路径
        ComponentScan componentScan =
                (ComponentScan)this.target_config.getAnnotation(ComponentScan.class);

        //得到包路径 path
        String path = componentScan.value();//path = com.jeffrey.spring.component
        //扫描该包
        ClassLoader classLoader = SpringApplicationP.class.getClassLoader();
        //加载器处理路径需要将 . 换位 /
        path = path.replace(".","/");
        URL resource = classLoader.getResource(path);
        System.out.println(resource.getPath());
        File file = new File(resource.getFile());
        //判断是否是文件夹（有多个类信息）
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 :files) {
                //通过文件名获取类名
                String path1 = file1.getPath();//path1 instanced：G:\Desktop\document\DetailFrame\Myspring\target\classes\com\jeffrey\spring\component\MonsterService.class
//                判断是否为class
                if (path1.endsWith(".class")){
                    String className=
                            path1.substring(path1.lastIndexOf("\\") + 1,path1.indexOf(".class"));
                    //path还为\
                    path = path.replace("/",".");
                    String fullName = path + "." + className;
                    //判断类信息是否有注解，然后进行反射
                    try {
                        Class<?> aClass = classLoader.loadClass(fullName);
                        if (aClass.isAnnotationPresent(Component.class)){
                            //如果是该注解，就进行反射，得到对象后加载到容器中
                            System.out.println("是一个bean ------" + aClass);
                            //1.得到Component 的value信息  如果没有就用类名作为name
                            Component componentAnnotation = aClass.getDeclaredAnnotation(Component.class);
                            String beanName = null;
                            if ("".equals(componentAnnotation.value())){
                                beanName = StringUtils.uncapitalize(className);
                            }else {
                                beanName = componentAnnotation.value();
                            }
                            //2.将 Bean 的信息封装到BeanDefinition对象 --》放入到BeanDefinitionMap中
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setClazz(aClass);
                            //3.判断该类有没有scope
                            if (aClass.isAnnotationPresent(Scope.class)){
                                Scope declaredAnnotation = aClass.getDeclaredAnnotation(Scope.class);
                                //得到value ，放入到 beanDefinition 对象
                                //scope 有值赋值
                                if ("".equals(declaredAnnotation.value())){
                                    beanDefinition.setScope("singleton");
                                }else {
                                    beanDefinition.setScope(declaredAnnotation.value());
                                }
                            }else {//没有scope 默认 singleton
                                beanDefinition.setScope("singleton");
                            }
                            //将beanDefinition 对象 放入 BeanDefinitionMap 中去
                            beanDefinitionMap.put(beanName,beanDefinition);
                        }else {
                            System.out.println("不是一个bean ---" + aClass);
                        }

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

            }

        }
    }
}
