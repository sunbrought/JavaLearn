package com.company.String;

public class StringDeno {
    public static void main(String[] args) {
        //“.”分割字符串为空
        String str="a,b,c,d,e,f";
        String strMath=createString(str);
        splitString(strMath);
        toArray(strMath);
        StringNumDemo();
        NumStringDemo();
        StringOperate(str);
    }
    public static String createString(String str){
        String str1=new String();
        str1=str;
        return str1;
    }
    public static void splitString(String str){
        System.out.println("需要切割的字符串:");
        String[] str1=str.split(",");
        for(int i=0;i<str1.length;i++){
            System.out.println("切割的字符串为："+i);
        }
    }
    //将字符串转为字符数组
    public static void toArray(String str){
        char[] chars=str.toCharArray();
        for(char c : chars){
            System.out.println("转为的字符数组为:"+c);
        }
    }
    //String数组转换
    public static void StringNumDemo(){
        //转为int型
        String numIntDemo="12345";
        //第一种方法
        int numInt=Integer.parseInt(numIntDemo);
        //第二种方法
        int a=Integer.valueOf(numInt).intValue();
        System.out.println("获取变量的类型："+getType(a));
        System.out.println(numInt);
    }
    //获取一个变量的类型（使用反射）
    public static String getType(Object object){
        return object.getClass().toString();
    }
    //将数值类型转为字符串
    public static void NumStringDemo(){
        int a=123;
        //第一种方法
        String str=Integer.toString(a);
        //第二种方法
        String str1=String.valueOf(a);
        System.out.println("数值类型转为字符串:"+str+","+str1);
    }
    //常用的处理字符串的方法
    public static void StringOperate(String str){
        //获取字符串的长度
        System.out.println("字符串的长度："+str.length());
        //字符串的比较
        String str1="abcefg ";
        System.out.println("字符串的比较："+str.equals(str1));
        //字符串去掉起始和结尾的空格
        System.out.println("字符串去掉起始和结尾的空格："+str1.trim());
        //转换小写
        System.out.println("转换小写："+str1.toLowerCase());
        //转换大写
        System.out.println("转换大写:"+str1.toUpperCase());
        //检索字符出现的位置(搜索不到返回-1)
        System.out.println("检索字符出现的位置："+str1.indexOf("b"));
        //截取字符串
        System.out.println("截取字符串："+str1.substring(1));
        //字符串开始的位置
        System.out.println("字符串开始的位置:"+str1.startsWith("c"));
        //字符串指定后缀结束
        System.out.println("字符串指定后缀结束:"+str1.endsWith("f"));
        //判断字符串是否为空
        System.out.println("判断字符串是否为空:"+str1.isEmpty());
        //获取指定字符的位置
        System.out.println("获取指定字符的位置:"+str1.charAt(3));
    }
}
