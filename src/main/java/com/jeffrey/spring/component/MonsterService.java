package com.jeffrey.spring.component;

import com.jeffrey.spring.Annotation.Autowired;
import com.jeffrey.spring.Annotation.Component;
import com.jeffrey.spring.Annotation.Scope;

/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-17 15:07
 * @description:
 **/

@Component
@Scope(value = "prototype")
public class MonsterService {

    //使用自己的注解来修饰属性
    //表示该属性是通过容器完成依赖注入
    //说明：我们按照名字来进行组装
    @Autowired
    private MonsterDao monsterDao;

    public void m1(){
        monsterDao.hi();
    }
}
