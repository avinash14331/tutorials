package com.learn.java.test;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args) {
//        String s="WomensDAY";
//        System.out.println(countSubstring(s));
//        String s= "abcabca";
//        System.out.println(minOperation(s));
        int[] arr={6, 2, 5, 3};
//        String s= "abcabca";
        System.out.println(pairs(4,arr));
    }
    static int  countSubstring(String S)
    {
        char[] chars= S.toCharArray();
        int countU=0,countL=0, resCount=0;
        // code here
        for(int i=0;i<S.length();i++){
            for(int j=i+1;j<=S.length();j++) {
                if((i+j)%2==0){
                    String str = S.substring(i,j);
                    char[] strChars= str.toCharArray();
                    for(int k=0;k<strChars.length;k++){
                        if(Character.isUpperCase(strChars[k])){
                            countU++;
                        }else if(Character.isLowerCase(strChars[k])){
                            countL++;
                        }

                    }
                    if(countU==countL){
                        resCount++;
                    }
                    countU=0;
                    countL=0;
                }

            }
        }
        return resCount;
    }

//    static int minOperation(String s) {
//        // code here
//        Set<String> set=new HashSet<>();
//        int count=0;
//        String temp="";
//        char[] chars=s.toCharArray();
//        for(int i=0;i<chars.length;i++){
//            temp=temp+chars[i];
//            if(!set.contains(temp) && !set.contains(chars[i])){
//                set.add(temp);
//                count++;
//            }
//        }
//    }

    static long pairs(int N, int arr[]) {
        // code here
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                long t1= (arr[i]&arr[j]);
                long t2= (arr[i]^arr[j]);
                if(t1>t2)
                    count++;
            }
        }
        return count;
    }
}
//gEEk
// gE
//Ek
// gEEk
// EEk
// Ek
