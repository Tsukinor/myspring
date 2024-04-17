package com.jeffrey.spring.ioc;

import com.jeffrey.spring.Annotation.Component;
import com.jeffrey.spring.Annotation.ComponentScan;

import java.io.File;
import java.net.URL;

/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-17 15:08
 * @description:
 **/
public class SpringApplicationP {
    private Class target_config;

    public SpringApplicationP(Class target_config){
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
                            System.out.println(aClass.getName());
                        }

                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }

            }

        }
    }
}
