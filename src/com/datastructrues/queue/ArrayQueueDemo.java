package com.datastructrues.queue;

//数组队列
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue=new ArrayQueue(5);
        System.out.println("判断队列是否为空："+arrayQueue.isEmpty());
        System.out.println("判断队列是否装满："+arrayQueue.ifFull());
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(5);
        arrayQueue.addQueue(6);
        System.out.println("出队列的数字："+arrayQueue.getQueue());
        arrayQueue.showQueue();
        arrayQueue.headQueue();
    }
}
//使用数组模拟队列，编写一个ArrayQueue类
class ArrayQueue{
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据，模拟队列

    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        front=-1;//指向队列头部，分析出front是指向队列头部的前一个位置
        rear=-1;//指向队列的尾部，指向队列尾部的数据(即就是队列最后一个位置)
    }

    //判断队列是否满
    public boolean ifFull(){
        return rear==maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front==rear;
    }

    //往队列中添加值
    public void addQueue(int n){
        //判断队列是否满
        if(ifFull()){
            System.out.println("队列满，不能加入数据---");
            return;
        }
        rear++;//队列rear往后移动
        arr[rear]=n;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据---");
        }
        front++;
        return arr[front];
    }

    //显示队列所有的数据，
    public void showQueue(){
        //遍历
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据---");
        }
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示队列的头数据，注意不是取出数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据---");
        }
        System.out.println("显示队列头部的数据："+arr[front+1]);
        return arr[front+1];
    }
}
