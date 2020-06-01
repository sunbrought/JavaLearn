package com.company.UntilClass;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        getSystemin();

        }
    //系统中输入值并打印
    public static void getSystemin(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("scaner");
        while(scanner.hasNext()){
            String str=scanner.next();
            System.out.println("输入的字符串："+str);
        }
    }
}
