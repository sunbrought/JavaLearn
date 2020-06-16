package com.shujujiegou.array;

public class BasicMehod {
    //定义数组
    private int intArray[];
    //定义数组下标
    private int elems;
    //定义数组长度
    private int length;

    //定义构造器
    public BasicMehod(int max){
        //定义数组的长度
        length=max;
        intArray=new int[max];
        //初始化数组下标
        elems=0;
    }

    //添加
    public void add(int value){
        //判断数组是否拥有空间
        if(elems==length){
            System.out.println("数组已经没有储存空间！");
            return;
        }
        //将值存入数组
        intArray[elems]=value;
        //下标加一
        elems++;
    }
    //查找,返回查找的个数(返回数组下标)
    public int find(int searchKey){
        //定义寻找操作的数组下标
        int i;
        for(i=0;i<elems;i++){
            //判断是否为需要查找的值
            if(intArray[i]==searchKey){
                break;
            }
        }
        //如果数组没有此值则查找失败
        if(i==length){
            return -1;
        }
        return i;
    }
    //删除,返回布尔值判断是否删除成功
    public boolean delete(int value){
        //查找数值获得数组下标
        int i=find(value);
        //数组中没有此值
        if(i==-1){
            return false;
        }
        //循环移动查找字符后面的字符
        for(int j=i;j<elems-1;j++){
            //将后面的数据往前移
            intArray[j]=intArray[j+1];
        }
        //下标减一
        elems--;
        return true;
    }
    //修改
    public boolean update(int oldValue,int newValue){
        //查找需要修改的字符
        int i=find(oldValue);
        //数组中没有需要修改的字符
        if(i==-1){
            System.out.println("数组中没有找到此字符！");
        }
        intArray[i]=newValue;
        return true;
    }
    //显示所有
    public void display(){
        for(int i=0;i<elems;i++){
            System.out.print(intArray[i]+" ");
        }
        System.out.println("\n");
    }
    //主函数
    public static void main(String[] args) {
        BasicMehod basicMehod=new BasicMehod(10);
        basicMehod.add(100);
        basicMehod.add(101);
        basicMehod.add(102);
        basicMehod.add(103);
        basicMehod.add(104);
        basicMehod.add(105);
        basicMehod.find(101);
        basicMehod.delete(105);
        basicMehod.update(100,105);
        basicMehod.display();
    }
}
