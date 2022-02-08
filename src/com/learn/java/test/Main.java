package com.learn.java.test;

import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        sc.nextLine();
        String[] strArr=new String[n];
        for(int i=0;i<strArr.length;i++){
            strArr[i] = sc.nextLine();
        }
        Deque<String> deque=new ArrayDeque<>();
        for(String s:strArr){
            String[] s1=s.split("\\s");
            if(s1[0].equals("1"))
                deque.offer(s1[1]);
            else if(s1[0].equals("2"))
                deque.offerFirst(s1[1]);
            else if(s1[0].equals("3")){
                String s2= deque.peekFirst();
                if(s2==null)
                    System.out.println(-1);
                else
                    System.out.println(s2);

            }
            else if(s1[0].equals("4")){
                String s2= deque.peekLast();
                if(s2==null)
                    System.out.println(-1);
                else
                    System.out.println(s2);
            }
            else if(s1[0].equals("5")){
                String s2= deque.pollFirst();
                if(s2==null)
                    System.out.println(-1);
                else
                    System.out.println(s2);
            }
            else if(s1[0].equals("6")){
                String s2= deque.pollLast();
                if(s2==null)
                    System.out.println(-1);
                else
                    System.out.println(s2);
            }
        }
    }
}