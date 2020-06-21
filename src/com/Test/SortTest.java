package com.Test;

public class SortTest {
    public static void main(String[] args) {
        int[] array={34,24,76,45,85,46,8,44,94};
        System.out.print("需要排列的数：");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+"、");
        }
        MaoPaoSort(array);
        XuanZeSort(array);
        CharRuTest(array);
    }
    //冒泡排序
    public static void MaoPaoSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int temp;
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }

        System.out.print("\n"+"冒泡排序后的数字：");
        for(int v : array){
            System.out.print(+v+"-");
        }
    }
    //选择排序
    public static void XuanZeSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int min=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            if(i!=min){
                int temp=array[i];
                array[i]=array[min];
                array[min]=temp;
            }
        }
        System.out.print("\n"+"选择排序后的数字：");
        for(int v : array){
            System.out.print(+v+"-");
        }
    }
    //插入排序
    public static void CharRuTest(int[] array){
        int j;
        for(int i=1;i<array.length;i++){
            int temp = array[i];
            j=i;
            while(j>0&&array[j]<array[j-1]){
                array[j]=array[j-1];
                j--;
            }
            array[j] = temp;
        }
        System.out.print("\n"+"插入排序后的数字：");
        for(int v : array){
            System.out.print(+v+"-");
        }
    }
}
