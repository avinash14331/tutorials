package com.learn.java.design_pattern.structural.adapter;

public class Employee {
    int ID;
    String name;
    public Employee(int id, String name){
        this.ID = id;
        this.name = name;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}
