package com.learn.java.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(() -> {
            System.out.println("We are in Thread : "+Thread.currentThread().getName());
            System.out.println("Priority of Thread : "+Thread.currentThread().getPriority());
            throw new RuntimeException();
        });
        t.setName("Worker");
        t.setPriority(Thread.MAX_PRIORITY);
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Exception occured in Worker Thread");
            }
        });
        System.out.println("Started From Thread : "+Thread.currentThread().getName());
        t.start();
        System.out.println("We are in Thread : "+Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("We are in End Thread : "+Thread.currentThread().getName());
    }
}
