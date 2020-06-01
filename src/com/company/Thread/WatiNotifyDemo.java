package com.company.Thread;
class Info {
    private String title;
    private String content;
    private Boolean flag=true;
    public synchronized void set(String title,String content){
        if(this.flag==false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.title=title;
            this.content=content;
            flag=false;
            super.notify();
        }
    }
    public synchronized void get(){
        if(this.flag==true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.title + "----" + this.content);
        flag=true;
        super.notify();
    }
}
class Producer1 implements Runnable {				// 定义生产者
    private Info info = null ;
    public Producer1(Info info) {
        this.info = info ;
    }
    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {				// 生产50次数据
            if (x % 2 == 0) {
                this.info.set("卡卡西","非常睿智！") ;		// 设置title属性

            } else {
                this.info.set("佐助","非常勇敢！") ;			// 设置title属性
            }
        }
    }
}
class Consumer1 implements Runnable {				// 定义消费者
    private Info info = null ;
    public Consumer1 (Info info) {
        this.info = info ;
    }
    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {					// 取走50次数据
            this.info.get();
        }
    }
}
public class WatiNotifyDemo {
    public static void main(String[] args) {
        Info info=new Info();              // 定义Message对象，用于保存和取出数据
        new Thread(new Producer1(info)).start();        // 启动生产者线程
        new Thread(new Consumer1(info)).start();
    }
}
