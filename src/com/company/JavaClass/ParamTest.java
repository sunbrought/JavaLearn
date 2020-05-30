package com.company.JavaClass;

import java.lang.reflect.Field;

public class ParamTest {
    public static void main(String[] args) throws NoSuchFieldException {
        HeroPlus heroPlus=new HeroPlus();
        //使用传统的方式修改name的值为garen
        heroPlus.name="garen";

        //获取类HeroPlus的名字叫做name的字段(getField只能获取公共的和父类继承的属性。
        // getDeclaredField()获取的是包括私有的但不包括父类继承的,如果访问私有属性的值使用setAccessible(true))
        Field field=heroPlus.getClass().getDeclaredField("name");
        //修改这个字段的值
        try {
            field.set(heroPlus,"temmo");
            System.out.println("改变后的值："+field.get(heroPlus));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
