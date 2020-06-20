package com.shujujiegou.array;

public class XuZeSort {
    public static void main(String[] args) {
        int[] arrays=new int[]{12,34,43,23,9,42,98};
        System.out.print("需要排序的数字：");
        for(int k=0;k<arrays.length;k++){
            System.out.print(arrays[k]+"、");
        }
        sort(arrays);
    }
    public static void sort(int[] arrays){
        //排序的趟数
        for(int i=0;i<arrays.length-1;i++){
            System.out.println("第"+(i+1)+"趟：");
            int min=i;
            //每次选择最小的进行交换位置
            //每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的
            // 就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
            for(int j=i+1;j<arrays.length;j++){
                System.out.print("排序的次数："+j+"--");
                if(arrays[j]<arrays[min]){
                    min=j;
                }
                if(i!=min){
                    int temp;
                    temp=arrays[i];
                    arrays[i]=arrays[min];
                    arrays[min]=temp;
                }
            }
        }
        System.out.println("排序后的数字：");
        for(int f=0;f<arrays.length;f++){
            System.out.print(arrays[f]+"、");
        }
    }
}
