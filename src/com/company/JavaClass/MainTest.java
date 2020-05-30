package com.company.JavaClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTest {
    public static void main(String[] args) throws NoSuchMethodException {
        //获取HeroPlus类的对象字节码
        try {
            Class clazz=Class.forName("com.company.JavaClass.HeroPlus");
            //获取main方法，第一个参数：方法名称，第二个参数：方法形参的类型
            Method method=clazz.getMethod("main", String[].class);
            //调用main方法
            try {
                //第一个参数对象类型，因为方式是静态的，所以为null可以，第二个为参数这里是String数组
                //要将这里的数组拆开了三个对象，所以要将它进行强转
                method.invoke(null,(Object) new String[]{"1","2","3","4"});
                //第二种方式
                method.invoke(null,new Object[]{new String[]{"1","2","3","4"}});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
