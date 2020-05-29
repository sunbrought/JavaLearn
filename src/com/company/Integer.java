package com.company;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Integer {
    public static void main(String[] args) {
        //int与Integer的区别
        String str=new String("str");
        java.lang.Integer a =new java.lang.Integer(3);
        java.lang.Integer b=4;
        java.lang.Integer d=4;
        int c=3;
        System.out.println(a==c);
        System.out.println(b==d);
        System.out.println(str);
        System.out.println(a);
        System.out.println(a==b);

        //编码字符的操作
        translate("Hello");
        //自动装箱拆箱
        getInteger(1234);
        //ArrayList与Array之间的转换
        getArrayList();
    }
    //输出编码字符的操作
    public static String translate(String str){
        String tempStr=str;
        try {
            tempStr=new String(tempStr.getBytes("ISO-8859-1"),"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        tempStr=tempStr.trim();
        System.out.println(tempStr);
        return tempStr;
    }
    //自动装箱,自动装箱
  /*  Integer total = 99;
    执行上面那句代码的时候，系统为我们执行了：
    Integer total = Integer.valueOf(99);
    int totalprim = total;
    执行上面那句代码的时候，系统为我们执行了：
    int totalprim = total.intValue();*/
    public static void getInteger(int a){
        //自动装箱实际底层调用Integer的valueOf()方法，jdk1.5之后提供了自动装拆箱的功能,
        // 定义的时候自动装箱Integer number=100;
        java.lang.Integer number= java.lang.Integer.valueOf(100);
        //自动拆箱，jdk1.5之后简化写int aaa=number;
        int aaa=number.intValue();
        System.out.println(number==aaa);//true,自动插箱成int型进行比较

        java.lang.Integer num1=100;
        java.lang.Integer num2= new java.lang.Integer(100);
        java.lang.Integer num3= java.lang.Integer.valueOf(100);
        //num3调用toString()方法返回的是一个字符串类型的值
        System.out.println(num1.toString().equals(num3.toString()));
        //num1返回的是Integer类型的对象，num2返回的是String对象
        System.out.println(num1==num2);
        //自动装箱
        System.out.println(num1==num3);
    }
    //Array和ArrayList的区别
    public static void getArrayList(){
        //把ArrayList转换为Array数组
        List<String> list=new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        int size=list.size();
        String[] array=(String[])list.toArray(new String[size]);
        for(String i:array){
            System.out.println("array中的值为："+i);
        }
        //把Array数组转换为ArrayList数组
        String[] str=new String[3];
        str[0]="A";
        str[1]="B";
        str[2]="C";
        List<String> asList=Arrays.asList(str);
        for(String i:asList){
            System.out.println("ArrayList中的值为:"+i);
        }
    }

}
