package com.company;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Integer {
    public static void main(String[] args) {
        String str=new String("str");
        java.lang.Integer a =new java.lang.Integer(3);
        java.lang.Integer b=4;
        int c=5;
        System.out.println(str);
        System.out.println(a);
        System.out.println(a==b);
        System.out.println(a==c);
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
     /*       Tomcat默认全部都是用ISO-8859-1编码,不管你页面用什么显示,Tomcat最终还是会替你将所有字符转做ISO-8859-1.
            那么,当在另目标页面再用GBK翻译时就会将本来错的编码翻译成GBK的编码,这时的文字会乱码.所以需要先将得到”字符”
            (不管是什么)都先用字节数组表示,且使用ISO-8859-1进行翻译,得到一个在ISO-8859-1编码环境下的字节数组.例如:
            AB表示成[64,65].然后再用GBK编码这个数组,并翻译成一个字符串.那么我们可以得到一个编码转换的过程
            假设:GBK码(“你”)->URLencode后变成->(%3F%2F)->Tomcat自动替你转一次ISO- 8859-1->得到
                    ( 23 43 68 23 42 68 每一个符号表示为ISO-8859-1中的一个编码)->接收页面—>再转一次
        为ISO-8859-1的Byte数组 [23,43,68,23,42,68]—>用GBK再转为可读的文字—>(%3F%2F”—->转为(“你”)*/
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
        java.lang.Integer number=100;
        //自动拆箱
        int aaa=number.intValue();
        System.out.println(aaa);
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
