package com.learn.java.lambdas;

import java.util.Comparator;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        /**
         * prior java 8
         */
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("Result of comparator:"+comparator.compare(3,2));
        /**
         * Lambda Comparator
         */
        Comparator<Integer> comparatorLambda = (o1,o2) -> o1.compareTo(o2);
        System.out.println("Result of lambda comparator:"+comparatorLambda.compare(3,2));
    }
}
