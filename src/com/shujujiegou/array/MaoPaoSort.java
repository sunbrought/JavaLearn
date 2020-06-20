package com.shujujiegou.array;

import java.util.Arrays;
/*
* 冒泡排序
* 每趟冒出一个最大数和一个最小数
*  每次运行的数量：总数量-运行的躺数（以冒出）
* */
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] arrays=new int[]{12,34,43,23,9,42,98};
        System.out.print("需要排序的数字：");
        for(int k=0;k<arrays.length;k++){
            System.out.print(arrays[k]+"、");
        }
        sort(arrays);
    }
    public static void sort(int[] arrays){
        //运行的趟数n-1
        for(int i=0;i<arrays.length-1;i++){
            System.out.println("第"+(i+1)+"趟：");
            //每趟运行的次数，n-i-1是为了防止数组越界,也可以将变量值定为1
            for(int j=0;j<arrays.length-i-1;j++){
                System.out.print("排序的次数："+j+"--");
                if(arrays[j]>arrays[j+1]){
                    int temp;
                    temp=arrays[j];
                    arrays[j]=arrays[j+1];
                    arrays[j+1]=temp;
                }
            }
        }
        System.out.println("排序后的数字：");
        for(int f=0;f<arrays.length;f++){
            System.out.print(arrays[f]+"、");
        }
    }
}


