package com.company.ObjectSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Collections工具类的sort方法有两种重载的形式，第一种要求传入的待排序容器中存放的对象比较实现Comparable接口
        以实现元素的比较；第二种不强制性的要求容器中的元素必须可比较，但是要求传入第二个参数，参数是
        Comparator接口的子类型（需要重写compare方法实现元素的比较），相当于一个临时定义的排序规则，
        其实就是通过接口注入比较元素大小的算法，也是对回调模式的应用（Java中对函数式编程的支持）。*/
public class CompartorTest {
    public static void main(String[] args) {
        Staff p1=new Staff("cuiyang",34,5500);
        Staff p2=new Staff("liming",43,6578);
        Staff p3=new Staff("jerry",36,7565);
        Staff p4=new Staff("alince",23,5454);
        Staff p5=new Staff("John",34,7677);
        Staff p6=new Staff("zhangsan",34,3434);
        List<Staff> list=new ArrayList<Staff>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        System.out.println("--------排序前----------");
        for(Staff staff : list){
            System.out.println(staff);
        }
        //排序要使用自定义的比较类
        StaffComparator myComparator=new StaffComparator();
        Collections.sort(list,myComparator);
        System.out.println("--------排序后----------");
        for(Staff staff : list){
            System.out.println(staff);
        }
    }
}
