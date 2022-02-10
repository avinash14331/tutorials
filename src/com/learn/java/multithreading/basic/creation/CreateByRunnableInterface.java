package com.learn.java.multithreading.basic.creation;

public class CreateByRunnableInterface {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RunnableThread());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(6000);
        System.out.println(thread.getState());


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
