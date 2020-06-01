package com.company.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateArray {

    public static void main(String[] args) {
        getCreateArray1();
        getCreateArray2();
        getCreateArray3();
        getArrayList();
    }
    public static void getCreateArray1(){
        //在声明的时候直接就已经分配空间，并赋值，不能写成先定义然后赋值
        String[] str={"a","b","c"};
        for(int x=0;x<str.length;x++){
            System.out.println(str[x]);
        }
    }
    //方法2和方法3是可以写成先声明后分配内存（在栈空间中分配一个引用，存放的是一个引用）
    private static String[] str,str1;
    public static void getCreateArray2(){
        //到这步的时候jvm开始在内存堆区域分配空间，并赋值
        str=new String[]{"a","b","c"};
        for(int x=0;x<str.length;x++){
            System.out.println(str[x]);
        }
    }
    //内存一但分配不可改变，所以说数组的长度是固定的
    public static void getCreateArray3(){
        //默认初始化，基本类型是0，引用类型是null,布尔类型是false
        str1=new String[3];
        str1[0]="a";
        str1[1]="b";
        str1[2]="c";
        for(int x=0;x<str1.length;x++){
            System.out.println(str1[x]);
        }
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
        List<String> asList= Arrays.asList(str);
        for(String i:asList){
            System.out.println("ArrayList中的值为:"+i);
        }
    }

}
