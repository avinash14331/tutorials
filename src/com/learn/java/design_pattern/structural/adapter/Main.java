package com.learn.java.design_pattern.structural.adapter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IEmployee employee= new EmployeeAdapter();
        List<Employee> list= ((EmployeeAdapter) employee).getEmployees();
        list.stream().forEach(System.out::println);
    }
}
