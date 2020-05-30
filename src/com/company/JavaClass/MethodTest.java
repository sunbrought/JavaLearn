package com.company.JavaClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.DoubleToIntFunction;

public class MethodTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String classname="com.company.JavaClass.HeroPlus";
        try {
           Class heroPlus= Class.forName(classname);
           Object obj = null;
           Constructor con=heroPlus.getConstructor(null);
            try {

                obj=con.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            System.out.println(obj);
           // 获取这个名字叫做setName，参数类型是String的方法
          Method method= heroPlus.getMethod("setName",String.class);
           //调用方法（obj : 要调用方法的对象，args:调用方式时所传递的实参）
            method.invoke(obj,"盖伦");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
