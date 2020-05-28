package com.company;

import java.io.UnsupportedEncodingException;

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
}
