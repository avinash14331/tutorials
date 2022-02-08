package com.learn.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StaticProblem {

    // Write your code here
    public static int B ;
    public static int H ;
    public static boolean flag = false;
    static {
        Scanner sc= new Scanner(System.in);
        B=sc.nextInt();
        H= sc.nextInt();
        sc.close();
        if(B <0 || H<0) {
            flag = false;
            try {
                throw new Exception("java.lang.Exception: Breadth and height must be positive");
            } catch (Exception e) {
                System.out.println(e.getMessage());
//                e.printStackTrace();
            }
        }
        else
            flag=true;

    }

    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main
}
