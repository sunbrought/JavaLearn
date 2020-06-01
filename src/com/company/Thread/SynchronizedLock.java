package com.company.Thread;
//
class A{
    public synchronized void say(B b){
        System.out.println("A:把你的笔给我，我给你本！");
        b.get();
    }
    public synchronized void get(){
        System.out.println("A得到了笔，送出了笔！");
    }
}
class B{
    public  void say(A a){
        System.out.println("B:把你的本给我，我给你笔！");
        a.get();
    }
    public synchronized void get(){
        System.out.println("B得到了笔，送出了笔！");
    }
}
public class SynchronizedLock implements Runnable{
    private static A a=new A();
    private static B b=new B();
    public static void main(String[] args) {
        new SynchronizedLock();
    }
    public  SynchronizedLock(){
        new Thread(this).start();
        b.say(a);
    }
    @Override
    public void run() {
        a.say(b);
    }
}
