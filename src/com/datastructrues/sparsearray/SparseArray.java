package com.datastructrues.sparsearray;

import java.io.*;
import java.nio.Buffer;

/*稀疏数组*/
public class SparseArray {
    public static void main(String[] args) throws IOException {
        /*创建一个原始的二维数组 11*11
        * 0表示没有棋子，1表示黑子，2表示白子
        *  */
        int chessArr1[][]=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        System.out.println("原始的二维数组！");
        for(int[] row : chessArr1){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将二维数组转化为稀疏数组
        //1.先遍历二维数组，得到非0数据的个数
        int sum=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum:"+sum);
        //2.创建对应的稀疏数组

        int[][] sparseArr=new int[sum+1][3];
        //3.给稀疏数组赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        //4.遍历二维数组，将非0的值存放到sparseArr中
        int count=0;//创建一个计数器，记录是第几个非0的数据
        for(int i=0;i<11;i++){        
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    count++;
                   sparseArr[count][0]=i;
                   sparseArr[count][1]=j;
                   sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }
        write(sparseArr);
        //输出稀疏数组
        System.out.println("得到的稀疏数组为：");
        for(int[] row : sparseArr){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将稀疏数组恢复为原始的二维数组
        int[][] chessArray=new int[sparseArr[0][0]][sparseArr[0][1]];
        //在读取稀疏数组后几行的数据（从第二行开始），并赋给原始的二维数组即可
        for(int i=1;i<sparseArr.length;i++){
            chessArray[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        System.out.println("恢复后的二维数组：");
        for(int[] row : chessArray){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        sparseArr=read();
        System.out.println("读取磁盘的稀疏数组！");
        for(int[] row : sparseArr){
            for(int data : row){
                System.out.print(data+"\t");
            }
            System.out.println();
        }
    }
    public static void write(int sparseArr[][]){
        System.out.println("文件写入中----");
        File file=new File("F:/sparseArray.txt");
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter=new BufferedWriter(new FileWriter(file));
            if(!file.exists()){
                file.createNewFile();
            }
            StringBuffer allBuffer=new StringBuffer();
            for(int[] rows : sparseArr){
                StringBuffer rowsBuffer=new StringBuffer();
                for(int data : rows){
                    rowsBuffer.append(data+"\t");
                }
                allBuffer.append(rowsBuffer+"\n");
            }
            bufferedWriter.write(String.valueOf(allBuffer));
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int[][] read() throws IOException {
        System.out.println("读取磁盘的数据中~~~~~~");
        File file=new File("F:/sparseArray.txt");
        int[][] sparseArr = null;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String row = null;
            try {
                row=bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //分割成字符串返回数组类型
            String[] s = new String(row).split("\t");
            sparseArr = new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
            while ((row = bufferedReader.readLine()) != null) {
                String[] s2 = new String(row).split("\t");
                sparseArr[Integer.parseInt(s2[0])][Integer.parseInt(s2[1])] = Integer.parseInt(s2[2]);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sparseArr;
    }
}
