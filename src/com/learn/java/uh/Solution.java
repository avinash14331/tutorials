package com.learn.java.uh;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[] arr={2,3,4,5};
//        Comparator<Integer> cmp=Collections.reverseOrder();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
//        int[] arr={20, 39, 29, 51, 96, 32, 35, 50, 57, 7, 59, 51, 85, 55, 8, 26, 15, 4, 4, 18, 32, 49, 40, 46, 83, 77, 100, 92};
//        System.out.println(solve2(17224,100000884));
//        System.out.println(17224%3);
//        System.out.println(solve(2,6));
//        System.out.println(solve2(30,36));
//        System.out.println(solve2(26,34));
//        System.out.println(solve2(15,49));
//        System.out.println(solve2(10,20)); //8
    }
    public static int solve2(int A, int B) {
//        int cnt=0;
        long n= B-A+1;
        if(n%3==0){
            return (int) ((n) * 2)/3;
        }else if(n%3==1){
            if(A%3!=0)
                return (int) ((n+2) * 2)/3 -1;
            else
                return (int) ((n+2) * 2)/3 -2;
        }else{
            if(A%3==1)
                return (int) ((n+1) * 2)/3;
            else
                return (int) ((n+1) * 2)/3 -1;
        }


//            return (int) Math.ceil((double)n*(2/3));

    }
    public static int solve(int A, int B) {
        int[] arr=new int[3];
        int cnt=0;
        for(int i=1;i<=B;i++){
            if(i<=2){
                arr[i-1]=1;
                if(i>=A)
                    cnt++;
            }
            else{
                arr[2]=arr[1]+arr[0];
                arr[0]=arr[1];
                arr[1]=arr[2];
                if(i>=A && arr[2]%2!=0 )
                    cnt++;
            }
        }
        return cnt;
    }
}
