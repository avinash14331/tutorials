package com.learn.java.test;

class Solution_united {
    public static void main(String[] args) {
        String s="CABABD";
        System.out.println(solution(s));
    }
    public static String solution(String S) {
        int len=S.length();
        String s1="";
        // write your code in Java SE 8
        for(int i=0;i<len;i++){
            char c1=S.charAt(i);

            switch(c1){
                case 'A':
                    if(s1.length()!=0){
                        char c2= s1.charAt(s1.length()-1);
                        if(c2=='B'){
                            s1=s1.substring(0,s1.length()-1);
                        }else{
                            s1=s1+c1;
                        }
                    }else{
                        s1=s1+c1;
                    }

                    break;
                case 'B':
                    if(s1.length()!=0){
                        char c2= s1.charAt(s1.length()-1);
                        if(c2=='A'){
                            s1=s1.substring(0,s1.length()-1);
                        }else{
                            s1=s1+c1;
                        }
                    }else{
                        s1=s1+c1;
                    }
                    break;
                case 'C':
                    if(s1.length()!=0){
                        char c2= s1.charAt(s1.length()-1);
                        if(c2=='D'){
                            s1=s1.substring(0,s1.length()-1);
                        }else{
                            s1=s1+c1;
                        }
                    }else{
                        s1=s1+c1;
                    }
                    break;
                case 'D':
                    if(s1.length()!=0){
                        char c2= s1.charAt(s1.length()-1);
                        if(c2=='C'){
                            s1=s1.substring(0,s1.length()-1);
                        }else{
                            s1=s1+c1;
                        }
                    }else{
                        s1=s1+c1;
                    }
                    break;
                default:
                    s1=s1+c1;
                    break;
            }
        }
        return s1;
    }
}