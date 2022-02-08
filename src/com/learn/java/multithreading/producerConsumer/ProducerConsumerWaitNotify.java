package com.learn.java.multithreading.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWaitNotify {
    private static final int MAX_SIZE =5;
//    private static Lock lock = new ReentrantLock();
    private static Queue<Integer> queue = new LinkedList<Integer>();

    public static class Producer extends Thread{
        private final Queue<Integer> queue;
        private final int MAX_CAPACITY;
        public Producer(Queue<Integer> queue,int max_capacity) {
            this.queue = queue;
            MAX_CAPACITY = max_capacity;
        }
        @Override
        public void run(){
            int counter=0;
            while(true){
                try {
                    produce(counter++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        public void produce(Integer i) throws InterruptedException {
            synchronized(queue){
                if(queue.size()== this.MAX_CAPACITY) {
                    System.out.println("Cannot produce because queue is full");
                    queue.wait();
                }
                Thread.sleep(1000);
                queue.add(i);
                System.out.println("CProduced: "+i);
                queue.notifyAll();
            }
        }
    }

    public static class Consumer extends Thread{
        private final Queue<Integer> queue;
        public Consumer(Queue<Integer> queue){
            this.queue=queue;
        }
        @Override
        public void run(){
            while(true){
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public void consume() throws InterruptedException {
            if(queue.isEmpty()){
                System.out.println("Nothing to consume");
                queue.wait();
            }
            Thread.sleep(1000);
            int val = queue.poll();
            System.out.println("Consumed: "+val);
            queue.notifyAll();
        }
    }

}
