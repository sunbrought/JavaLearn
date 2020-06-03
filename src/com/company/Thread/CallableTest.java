package com.company.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//创建Callable接口的实现类，并实现call()方法，该call()方法将作为线程执行体，并且有返回值
public class CallableTest implements Callable {
    public static void main(String[] args) {
        //创建Callable实现类的实例，使用FutureTask类来包装Callable对象，该FutrueTask
        // 对象封装了该Callable对象的call()方法的返回值
        CallableTest callableTest=new CallableTest();
        FutureTask ft=new FutureTask(callableTest);
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"的循环变量i的值："+i);
            if(i==20){
                //使用FutureTask对象作为Thread对象的target创建并启动新线程
                new Thread(ft,"有返回值的线程").start();
            }
        }
        try {
            //调用FutureTask对象的get()方法来获得线程结束后的返回值
            System.out.println("子线程的返回值："+ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object call() throws Exception {
        int i=0;
        for(;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"  "+i);
        }
        return i;
    }
}
