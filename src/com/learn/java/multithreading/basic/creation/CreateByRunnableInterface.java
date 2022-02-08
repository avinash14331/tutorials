package com.learn.java.multithreading.basic.creation;

public class CreateByRunnableInterface {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableThread());
        thread.start();

    }
}
class RunnableThread implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("In run method using Runnable Interface having i: "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
