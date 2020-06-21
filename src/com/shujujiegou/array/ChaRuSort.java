package com.shujujiegou.array;

public class ChaRuSort {
    public static void main(String[] args) {
        int[] arrays=new int[]{12,34,43,23,9,42,98};
        System.out.print("需要排序的数字：");
        for(int k=0;k<arrays.length;k++){
            System.out.print(arrays[k]+"、");
        }
        insertSort(arrays);
        System.out.println("排序的数字：");
        for(int i=0;i<arrays.length;i++){
            System.out.print(arrays[i]+"-");
        }
    }
    public static void insertSort(int[] arrays){
        int j;
        for(int i = 1; i < arrays.length ; i++){
            int temp = arrays[i];
            j = i;
            while (j > 0 && temp < arrays[j-1]){
                arrays[j] = arrays[j-1];
                j--;
            }
            arrays[j] = temp;
        }
    }
}
