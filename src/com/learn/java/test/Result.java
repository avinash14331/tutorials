package com.learn.java.test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */
    public static void main(String[] args) {
        int n=6,k=3;
        String s="092282";
        System.out.println(highestValuePalindrome(s,n,k));
    }

    public static String highestValuePalindrome(String s, int n, int k) {
        // Write your code here
        int left=0,right=s.length()-1;
        boolean isPalin =true;
        Map<Integer,Integer> indexSwaped = new TreeMap<>();
        //Make Palindrome
        while(left<right){
            if(s.charAt(left)== s.charAt(right)){
                left++;right--;
            }else{
                if(k<=0){
                    isPalin =false;
                    break;
                }
                int l= Integer.parseInt(String.valueOf(s.charAt(left)));
                int r= Integer.parseInt(String.valueOf(s.charAt(right)));
                if(l>r){
                    s= getUpdatedString(s,right,s.charAt(left));
                    indexSwaped.put(left, l);
                }else{
                    s= getUpdatedString(s,left,s.charAt(right));
                    indexSwaped.put(left, r);
                }
                k--;
            }
        }

        // If Plaindrome optimize
        if(isPalin){
            if(k==0)
                return s;
            left=0;
            right=s.length()-1;
            for(Map.Entry e: indexSwaped.entrySet()){
                if(k<=0)
                    break;
                if(indexSwaped.get(e.getKey()) !=9){
                    s= getUpdatedString(s, (Integer) e.getKey(),'9');
                    s= getUpdatedString(s, s.length()-1-(Integer) e.getKey(),'9');
                    k--;
                }
            }
            while(left<right && k>1){
                if(s.charAt(left)!='9'){
                    s= getUpdatedString(s,left,'9');
                    s= getUpdatedString(s,right,'9');
                    k=k-2;
                }
            }
            if(k==1 && s.length()%2!=0){
                int mid= s.length()/2;
                if(s.charAt(left)!='9'){
                    s= getUpdatedString(s,mid,'9');
                }
                return s;
            }else{
                return s;
            }
        }
        else
            return "-1";
    }

    static String getUpdatedString(String s, int pos, char c){
        String s1= s.substring(0,pos);
        String s2= s.substring(pos+1);
        return s1+c+s2;
    }

}


