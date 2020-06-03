package com.company.Thread;

/*使用内部类实现线程设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。*/
public class InsideThread {
    private int j;

    public static void main(String[] args) {
        InsideThread insideThread=new InsideThread();
        Inc inc=insideThread.new Inc();
        Dec dec=insideThread.new Dec();
        for(int i=0;i<2;i++){
            Thread n=new Thread(inc);
            n.start();
            Thread c=new Thread(dec);
            c.start();
        }
    }
    public synchronized void inc(){
        j++;
        System.out.println("本线程名称："+Thread.currentThread().getName()+"-Inc"+j);
    }
    public synchronized  void dec(){
        j--;
        System.out.println("本线程名称："+Thread.currentThread().getName()+"-Dec"+j);
    }
    class Inc implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<100;i++){
                inc();
            }
        }
    }
    class Dec implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<100;i++){
                dec();
            }
        }
    }
}
