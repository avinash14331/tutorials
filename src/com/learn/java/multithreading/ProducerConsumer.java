package com.learn.java.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    private static final int BUFFER_SIZE=5;
    private static Lock lock =new ReentrantLock();
    private static Condition condition=lock.newCondition();
    private static final Queue<Integer> queue=new LinkedList<>();
//    private static final ModifiedLinkedList<Integer> queue= new ModifiedLinkedList<>();

    public static void main(String[] args) {
        Producer producer= new Producer(queue,BUFFER_SIZE);
        Consumer consumer= new Consumer(queue);
//        ProducerNew producer= new ProducerNew(lock,condition,queue,BUFFER_SIZE);
//        ConsumerNew consumer= new ConsumerNew(lock,condition,queue);
        producer.start();
        consumer.start();

    }

    public static class Producer extends Thread{
        private final Queue<Integer> queue;
        private final int MAX_CAPACITY;

        public Producer(Queue<Integer> queue,int max_capacity) {
            this.queue = queue;
            MAX_CAPACITY = max_capacity;
        }
        @Override
        public void run() {
            int counter=0;
            while(true){
                try {
                    produce(counter++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public void produce(int i) throws InterruptedException {
            synchronized(queue){
                while(queue.size()==MAX_CAPACITY){
                        System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + queue.size());
                        queue.wait();
                }
                Thread.sleep(1000);
                queue.add(i);
                System.out.println("Produced: " + i);
                queue.notifyAll();

            }
        }

    }

    public static class Consumer extends Thread{
        private final Queue<Integer> queue;

        public Consumer(Queue<Integer> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            while(true){
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void consume() throws InterruptedException {
            synchronized(queue) {
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + queue.size());
                    queue.wait();
                }
                Thread.sleep(1000);
                int i = queue.poll();
                System.out.println("Consumed: " + i);
                queue.notifyAll();
            }
        }
    }

    public static class ProducerNew extends Thread{
        private final Queue<Integer> queue;
        private final int MAX_CAPACITY;
        Lock lock;
        Condition condition;


        public ProducerNew(Lock lock, Condition con,Queue<Integer> queue,int max_capacity) {
            this.queue = queue;
            MAX_CAPACITY = max_capacity;
            this.lock=lock;
            this.condition=con;
        }
        @Override
        public void run() {
            int counter=0;
            while(true){
                try {
                    produce(counter++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public void produce(int i) throws InterruptedException {
//            Lock lock= queue.getObjLock();
//            Condition condition=lock.newCondition();
            lock.lock();
            try{
                while(queue.size()==MAX_CAPACITY){
                    System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + queue.size());
//                    queue.wait();
                    condition.await();
                }
                Thread.sleep(1000);
                queue.add(i);
                System.out.println("Produced: " + i);
//                queue.notifyAll();
                  condition.signalAll();
            }finally{
                lock.unlock();
            }
        }

    }

    public static class ConsumerNew extends Thread{
        Queue<Integer> queue;
        Lock lock;
        Condition condition;

        public ConsumerNew(Lock lock,Condition con,Queue<Integer> queue) {
            this.queue = queue;
            this.lock = lock;
            this.condition = con;
        }
        @Override
        public void run() {
            while(true){
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void consume() throws InterruptedException {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + queue.size());
                    condition.await();
                }
                Thread.sleep(1000);
                int i = queue.poll();
                System.out.println("Consumed: " + i);
                condition.signalAll();
            }finally{
                lock.unlock();
            }
        }
    }

}




