package com.learn.java.functionalinterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    static Consumer<Student> c1 = (student) -> System.out.print(student.getName());
    static Consumer<Student> c2 = (student) -> System.out.println(student.getActivities());
    static Consumer<Student> c3 = System.out::println;
    public static  void printStudents(){
        System.out.println();
        System.out.println("printStudents");
        List<Student> students=StudentDataBase.getAllStudents();
        students.forEach(c3);
    }

    public static void printNameAndActivities(){
        System.out.println();
        System.out.println("printNameAndActivities");
        List<Student> students=StudentDataBase.getAllStudents();
        students.forEach(c1.andThen(c2));  // Consumer Chaining
    }

    public static void printNameAndActivitiesWithFilter(){
        System.out.println();
        System.out.println("printNameAndActivitiesWithFilter");
        List<Student> students=StudentDataBase.getAllStudents();
        students.forEach(student -> {
            if(student.getGradeLevel()>=3)
                c1.andThen(c2).accept(student);
        });  // Consumer Chaining
    }

    public static void main(String[] args) {
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());

        c1.accept("java8");

        printStudents();

        printNameAndActivities();

        printNameAndActivitiesWithFilter();
    }
}
