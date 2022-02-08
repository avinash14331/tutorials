package com.learn.java.test;

import java.util.Scanner;
import java.util.Stack;

public class ExpressionBalancer {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String[] strArr=new String[n];
        for(int i=0;i<n;i++){
            strArr[i]=sc.nextLine();
        }

        for(String s:strArr){
            char[] chars=s.toCharArray();
            Stack<Character> stack=new Stack<>();
            int flag=0;
            for(int i=0;i<chars.length;i++){
                if(chars[i]=='(')
                    stack.push(chars[i]);
                else if(chars[i]==')'){
                    if(stack.isEmpty())
                    {
                        System.out.println(0);
                        flag=1;
                        break;
                    }
                    Character c= stack.pop();
                    while(c!='('){
                        if(c==')'){
                            System.out.println(0);
                            flag=1;

                        }
                        if(stack.isEmpty()){
                            System.out.println(0);
                            flag=1;
                            break;
                        }
                        c=stack.pop();
                    }
                }
            }
            if(flag==1)
                continue;
            if(stack.isEmpty())
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
