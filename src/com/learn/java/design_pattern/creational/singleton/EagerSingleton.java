package com.learn.java.design_pattern.creational.singleton;

public final class EagerSingleton {

    public static void main(String[] args) {
        Singleton instance=Singleton.getInstance();
        instance.printMsg();
    }
}
final class Singleton{
    private static volatile Singleton instance=new Singleton();
    private Singleton(){

    }
    public static  Singleton getInstance() {
        return instance;
    }
    public void printMsg(){
        System.err.println("Hello Singleton");
    }
}
