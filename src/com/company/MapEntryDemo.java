package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapEntryDemo {
    public static void main(String[] args) {
        //Map是java中的接口，Map.Entry是Map的一个内部接口。
        //keySet()方法返回值是Map中key值的集合；
        //entrySet()的返回值也是返回一个key的值集合，此集合的类型为Map.Entry
        /*
        * Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。
        * 它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。*/
        Map<String,String> map=new HashMap<String,String>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        //普遍使用这种方法
        System.out.println("通过Map.keySet()遍历key和value");
        for(String key :map.keySet()){
            System.out.println("key的值"+key+",value的值为："+map.get(key));
        }
        //推荐使用这种方法
        System.out.println("通过Map.entryset()遍历key和value");
        for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println("key的值"+entry.getKey()+",value的值为："+entry.getValue());
        }
        //使用iterator()方法
        System.out.println("通过Map.entryset().iterator()遍历key和value");
         Iterator<Map.Entry<String, String>> it=map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,String> entry=it.next();
            System.out.println("key的值"+entry.getKey()+",value的值为："+entry.getValue());
        }
        //通过Map.values()遍历所有的value，但不能遍历key
        System.out.println("通过Map.values()遍布所有的value,但不能便利key值");
        for(String v : map.values()){
            System.out.println("value的值为："+v);
        }
    }
}
