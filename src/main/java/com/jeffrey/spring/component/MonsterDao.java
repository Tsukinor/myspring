package com.jeffrey.spring.component;

import com.jeffrey.spring.Annotation.Component;
import com.jeffrey.spring.Annotation.Scope;


/**
 * @program: DetailFrame
 * @author: Jeffrey
 * @create: 2024-04-17 15:07
 * @description:
 **/
@Component(value = "monsterDao")
public class MonsterDao {

    public void hi(){
        System.out.println("MonsterDao --- hi() ");
    }
}
