package com.learn.java.datastructures;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InterviewService {
    public static void main(String[] args) {
        BlockingQueue<String> queue= new ArrayBlockingQueue<>(3);
        InterviewScheduler producer= new InterviewScheduler(queue);
        InterviewProcessor consumer= new InterviewProcessor(queue);
        Thread t1= new Thread(producer);
        Thread t2= new Thread(consumer);
        t1.start();
        t2.start();
    }
}
class InterviewScheduler implements Runnable {
    private BlockingQueue<String> queue;
    public InterviewScheduler(BlockingQueue<String> queue){
        this.queue = queue;
    }
    @Override
    public void run(){
        System.out.println("10 candidates have arrived");
        for(int i=0;i<10;i++){
            String s= "Candidate "+i;
            try {
                queue.put(s);
                System.out.println("Interview Scheduled for "+s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Interview scheduled for all candidate");
        String msg= new String("stop");
        try{
            queue.put(msg);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class InterviewProcessor implements Runnable {
    private BlockingQueue<String> queue;

    public InterviewProcessor(BlockingQueue<String> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        String msg;
        try {
            Thread.sleep(10000);
            while(!(msg = queue.take()).equals("stop")){
                System.out.println("interviewing " + msg);
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Interview Completed for all the candidates");

    }
}
