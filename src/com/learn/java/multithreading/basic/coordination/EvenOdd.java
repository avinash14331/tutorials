package com.learn.java.multithreading.basic.coordination;

public class EvenOdd {

    public static void main(String[] args) throws InterruptedException {
        NumberPrinter n = new NumberPrinter(20);
        Thread t1 = new NumberPrinterThread(n,false);
        Thread t2 = new NumberPrinterThread(n,true);
        t1.start();
        t2.start();
        t2.join();

    }
}
class NumberPrinter{
    private int n;
//    private int flag = 0;

    public NumberPrinter(int n) {
        this.n = n;
    }

    public void odd() {

        for (int i = 1; i <= n; i++) {
            synchronized(this) {
                while (n%2 == 0) {
                    try {
                        this.wait();
                    }
                    catch (Exception e) {

                    }
                }
                System.out.println(i);
//                flag = 1;
                this.notifyAll();
            }
        }
    }

    public void even() {

        for (int i = 1; i <= n; i++) {
            synchronized(this) {
                while (n%2 == 1) {
                    try {
                        this.wait();
                    }
                    catch (Exception e) {

                    }
                }
                System.out.println(i);
//                flag = 0;
                this.notifyAll();
            }
        }
    }
}
class NumberPrinterThread extends Thread{
    NumberPrinter numberPrinter;
    boolean iseven;
    public NumberPrinterThread(NumberPrinter numberPrinter,boolean iseven){
        this.numberPrinter = numberPrinter;
        this.iseven=iseven;
    }
    @Override
    public void run(){
        if(iseven){
            numberPrinter.even();
        }else{
            numberPrinter.odd();
        }

    }
}
