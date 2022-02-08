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



public class HourGlass2DArr {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.size()-2;i++){
            List<Integer> row1 = arr.get(i);
            List<Integer> row2 = arr.get(i+1);
            List<Integer> row3 = arr.get(i+2);
            int cnt=0,sum=0;
            for(int k=0;k<row1.size()-2;k++){
                int j=k;
                for(;j<=k+2;j++){
                    if(cnt!=1){
//                        if(row1.get(j)== row3.get(j)){
                            sum= sum+ (row1.get(j)+row3.get(j));
                            cnt++;

//                        }
//                        else
//                            break;
                    }
                    else{
//                        if(row1.get(j)== row3.get(j)){
                            sum= sum+ (row1.get(j)+row2.get(j)+row3.get(j));
                            cnt++;
//                        }
                    }
                }
                if(cnt>2){
                    if(maxSum<sum)
                        maxSum=sum;
                }
                cnt=0;
                sum=0;

            }
        }
        System.out.println(maxSum);
    }
}
