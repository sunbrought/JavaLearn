package com.company;

interface MyInterface{
    void IMthod(String str);
}
interface MyInterface1{
    int Imthod(int a, int b);
}
public class Lamda {
    //可以加一行语句也可以加多行语句
    public static void test(MyInterface myInterface){
        myInterface.IMthod("Hello!");
    }
    //还可以加一个表达式
    public static void demo(MyInterface1 myInterface1){
        int result=myInterface1.Imthod(2,32);
        System.out.println(result);
    }
    public static void main(String[] args) {
        //首先在()中定义此表达式里边需要接收的变量s,后面单行语句就可以使用该变量了
       test((s)-> System.out.println(s));
        demo((a,b)->a*b);
        //表达式的完整书写
        demo((a,b)->{ return a*b;});
    }
}
