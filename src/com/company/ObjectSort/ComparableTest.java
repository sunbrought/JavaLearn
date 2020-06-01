package com.company.ObjectSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*如果是对象，如何比较后排序呢？就需要用到这两个接口了，并且将自己定义的类作为参数传入接口泛型，
        在接口里重写比较方法，将自己要选择排序的类属性添加到比较条件中去。*/
//接口主要区别
/*（1）Comparable接口是在java.lang下，Comparator接口是在java.util下。
（2）如果在定义类时，就实现了Comparable接口，直接在里面重写compareTo()方法，如果没实现，
        后面在业务开发中需要有比较排序的功能，就再单独写一个类实现Comparator接口，在里面
        重写compare()方法，然后这个类需要作为参数传入到工具类Collections.sort和Arrays.sort方法中。
（3）实现Comparable接口的类必须是自然排序，另外一个不是强制条件。*/
public class ComparableTest {
    public static void main(String[] args) {
        //测试Comparable接口
        Person p1=new Person("cuiyang",34,5500);
        Person p2=new Person("liming",43,6578);
        Person p3=new Person("jerry",36,7565);
        Person p4=new Person("alince",23,5454);
        Person p5=new Person("John",34,7677);
        Person p6=new Person("zhangsan",34,3434);
        //添加到集合
        List<Person> list=new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        System.out.println("--------排序前----------");
        for(Person person : list){
            System.out.println(person);
        }
        //排序一般使用collections.sort方法，或者使用Arrays.sort方法，按照比较元素进行自然排序，即从小到大
        Collections.sort(list);
        System.out.println("--------排序后----------");
        for(Person person : list){
            System.out.println(person);
        }
    }
}
