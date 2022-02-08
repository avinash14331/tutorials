package com.learn.java.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] A={1,2,2,1};
        int[] B={2,3,1,2};
        System.out.println(Arrays.toString(solve(A,B)));
    }
    public static int[] solve(int[] A, int[] B){
        List<Integer> list= new LinkedList<>();
        for(int i=0;i<A.length;i++){
            list.add(A[i]);
        }
        List<Integer> resL= new LinkedList<>();
        for(int i=0;i<B.length;i++){
            if(list.contains(B[i])){
                resL.add(B[i]);
                list.remove((Object)B[i]);
            }
        }
        int[] res= new int[resL.size()];
        for(int i=0;i<resL.size();i++){
            res[i]=resL.get(i);
        }
        return res;
    }
}
