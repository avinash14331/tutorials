package com.learn.java.multithreading.basic.creation;

public class CreateByThreadClass {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.start();
    }
}
class Demo extends Thread{
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("In run method using Thread class having i: "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
