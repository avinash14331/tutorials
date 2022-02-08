package com.learn.java.test;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s= sc.nextLine();
        sc.close();
        String[] str=s.split(" ");
        for(String s1:str){
            System.out.println(s1);
        }
    }
//    public static int[] merge(int[] arr, int l,int m,int r){
//        int n1= m-l+1;
//        int n2= r-m;
//    }
}
