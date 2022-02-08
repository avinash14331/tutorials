package com.learn.java.design_pattern.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    public List<Employee> employees;
    public EmployeeManager(){
        employees= new ArrayList<>();
        this.employees.add(new Employee(1,"Avinash"));
        this.employees.add(new Employee(2,"John"));
        this.employees.add(new Employee(3,"Michael"));
        this.employees.add(new Employee(4,"Jason"));
    }
    public List<Employee> getEmployees(){
        return employees;
    }
}
