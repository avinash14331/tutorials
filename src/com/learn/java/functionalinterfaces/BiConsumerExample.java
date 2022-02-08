package com.learn.java.functionalinterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void printNameAndActivities(){
        BiConsumer<String,List<String>> b1= (a,b) -> System.out.println(a + b);
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(student -> {
            b1.accept(student.getName(),student.getActivities());
        });
    }
    public static void main(String[] args) {
        BiConsumer<String , String> b1= (s1,s2) -> System.out.println("a: "+s1+" b: "+s2);

        b1.accept("java7","java8");

        BiConsumer<Integer,Integer> multiply = (a,b) -> System.out.println("Multiplication: "+ a*b);

        BiConsumer<Integer,Integer> division = (a,b) -> System.out.println("Division: "+ a/b);

        multiply.andThen(division).accept(10,5);

        printNameAndActivities();

    }
}
