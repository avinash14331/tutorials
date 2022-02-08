package com.learn.java.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Solution {
    public static void main(String[] args) {
        String name= "header,header\n" +
                "ANNUL,ANNULED\n" +
                "null,NILL\n" +
                "NULL,NULL";
        System.out.println(solution(name));
//        inLimits("345K");
    }
    static  String solution(String s){
        String[] str= s.split("\n");
        int i=0,nullRow=0;
        String res="";
        for(String s1:str){
           if(i==0)
               i=1;
           else{
               String[] s2= s1.split(",");
               for(String s3:s2){
                   if(s3.equals("NULL")){
                       nullRow=1;
                       break;
                   }

               }
           }
           if(nullRow!=1){

               res+= s1 +"\n";
           }else{
               nullRow=0;
           }
        }
        return res;
    }
}
