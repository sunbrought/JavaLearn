package com.company.JavaClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class HeroTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String className= "com.company.JavaClass.Hero";
        //获取类对象
        System.out.println("-------获取类对象-------");
        Class hero=Class.forName(className);
        System.out.println(hero);
        System.out.println("-------获取公有的构造器方法-------");
        Constructor[] con=hero.getConstructors();
        for(Constructor c :con){
            System.out.println(c);
        }
        System.out.println("-------获取所有的构造器方法(包括私有的，受保护的)-------");
        Constructor[] cons=hero.getDeclaredConstructors();
        for(Constructor c :cons){
            System.out.println(c);
        }
        System.out.println("-------获取公有的无参的构造器方法-------");
        Constructor con1=hero.getConstructor();
        System.out.println(con1);
        //调用构造器方法
        Object obj=con1.newInstance();
        System.out.println("-------公有无参构造器方法已经调用-------"+obj);
        System.out.println("-------获取私有构造器方法并调用-------");
        Constructor con2=hero.getDeclaredConstructor(float.class);
        System.out.println("-------获取私有的构造器的方法"+con2);
        //调用私有的构造方法
        //(暴力访问)忽略掉访问修饰符
        con2.setAccessible(true);
        obj=con2.newInstance(100);
        System.out.println("-----成功调用私有的构造器方法"+obj);
    }
}
