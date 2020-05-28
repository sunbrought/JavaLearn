package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

class Message {
    private String title ;							// 保存信息的标题
    private String content ;
    private Boolean flag=true;// 保存信息的内容
    public synchronized void set(String title,String content){
        // flag == true：表示可以生产，但是不能取走
        // flag == false：表示可以取走，但是不能生产
        if(this.flag==false) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            this.title=title;
            try {
                Thread.sleep(200) ;			// 延迟操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.content=content;
            this.flag=false;
            super.notify();

    }
    public synchronized void get() {
        if (this.flag == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(200);            // 延迟操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.title + "----" + this.content);

        this.flag = true;
        super.notify();
    }
}
class Producer implements Runnable {				// 定义生产者
    private Message msg = null ;
    public Producer(Message msg) {
        this.msg = msg ;
    }
    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {				// 生产50次数据
            if (x % 2 == 0) {
                this.msg.set("卡卡西","非常睿智！") ;		// 设置title属性

            } else {
                this.msg.set("佐助","非常勇敢！") ;			// 设置title属性
            }
        }
    }
}
class Consumer  implements Runnable {				// 定义消费者
    private Message msg = null ;
    public Consumer (Message msg) {
        this.msg = msg ;
    }
    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {					// 取走50次数据
            this.msg.get();
        }
    }
}
public class TestDemo {
    public static void main(String[] args) throws Exception {
        Message msg = new Message();                // 定义Message对象，用于保存和取出数据
        new Thread(new Producer(msg)).start();        // 启动生产者线程
        new Thread(new Consumer(msg)).start();        // 取得消费者线程
    }
}
