package com.company.UntilClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Java对正则表达式得支持
public class RegExpTest {
    public static void main(String[] args) {
        String str="成都市(成华区)(武侯区)(高新区)";
        //Pattern创建一个正则表达式，也可以说是创建一个匹配模式
        Pattern p=Pattern.compile(".*?(?=\\()");
        //提供了对正则表达式得分组支持，以及正则表达式得多次匹配支持
        Matcher m=p.matcher(str);
        if(m.find()){
            System.out.println(m.group());
        }
    }
}
//简述下正则表达式及其用途
/*在编写字符串处理程序的时候，经常查找某些复杂规则得字符串得需要，正则表达式就是用于描述这些规则得工具，
正则表达式就是在进行处理和匹配时最为强大的工具， 绝大数语言都提供了对正则表达式得支持。*/
