package com.company;
class MyThread implements Runnable{
    private int tickets =5;
    @Override
    public void run() {
        this.sale();
        //同步代码块
       /* for(int x=0 ; x<5 ; x++){
            synchronized (this){
                if(this.tickets>0){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("票贩子"+Thread.currentThread().getName()+":"+tickets--);
                }
            }
        }*/
    }
    //同步方法
    public synchronized void sale(){
        for(int x=0;x<20;x++){
            if(tickets>0){
                System.out.println("票贩子"+Thread.currentThread().getName()+":"+tickets--);
            }
        }
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        MyThread mt=new MyThread();
        new Thread(mt,"线程A").start();
        new Thread(mt,"线程B").start();
        new Thread(mt,"线程C").start();
        new Thread(mt,"线程D").start();
        new Thread(mt,"线程D").start();
    }
}
