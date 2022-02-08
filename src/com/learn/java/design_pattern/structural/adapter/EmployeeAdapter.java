package com.learn.java.design_pattern.structural.adapter;

import java.util.List;

public class EmployeeAdapter extends EmployeeManager implements IEmployee{
    @Override
    public String getALlEmployees() {
        return null;
    }
    @Override
    public List<Employee> getEmployees(){
        List<Employee> employees= super.getEmployees();
        return employees;
    }
}
