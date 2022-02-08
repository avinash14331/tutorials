package com.learn.java.test;

public class Scaler {
    public static void main(String[] args) {
        int[] A= {0,0,1,1,1,0,0,1};
        int B=3;
        System.out.println(sum(A,3));
    }
    static int sum(int[] A , int B){
        int cnt=0,range= (B-1)*2;
        int left=0,right=A.length-1, count=0;
        int[] arr=new int[A.length];
        while(left<=right){
            if(A[left]==0) {
                left++;
            }
            else{
                int max = (left+1)+ B -1;
                int min= (right+1) -B +1;
//                if()
            }
            if(A[right]==0)
                right--;
        }
        return cnt;
    }
}
