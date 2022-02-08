package com.learn.java.test;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {
    public static void main(String[] args){
        char[] cArray1 = {'a'};
        System.out.println(longestPalindrome(cArray1));
    }
    static List<Character> longestPalindrome(char[] arr){
        List<Character> list= new ArrayList<>();
        List<Character> temp= null;
        int cnt=0,max=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i; j<arr.length;j++){
                cnt=0;
                temp=new ArrayList<>();
                for(int k=0;k<(j-i+1)/2;k++){
                    if(arr[i+k] == arr[j-k]){
                        temp.add(arr[i+k]);
                        cnt++;
                    }
                    else
                        break;
                }
                if(cnt>max){
                    max=cnt;
                    list=temp;
                }
            }


        }
        return list;
    }

}
