package com.learn.java.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HackerCatch {
    private static final int MAX_PASSWORD=9999;
    public static void main(String[] args) {
        Random random =new Random();

        Vault vault= new Vault(random.nextInt(MAX_PASSWORD));
        List<Thread> threads= new ArrayList<>();
        threads.add(new AscendingHacker(vault));
        threads.add(new DescendingHacker(vault));
        threads.add(new PoliceThread());

        for(Thread t:threads){
            t.start();
        }
    }

    private static class Vault {
        private int password;

        public Vault(int passwords) {
            this.password = password;
        }

        public boolean isCorrectPassword(int guess) {
            try {
                Thread.sleep(5000);

            } catch (InterruptedException e) {
            }
            return this.password == guess;
        }
    }

    private static abstract class HackerClass extends Thread {
        protected Vault vault;

        public HackerClass(Vault vault){
            this.vault=vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("Starting Thread: "+ this.getName());
            super.start();
        }
    }

    private static class AscendingHacker extends HackerClass{

        public AscendingHacker(Vault vault) {
            super(vault);
        }

        @Override
        public void run(){
            for(int i=0;i<MAX_PASSWORD;i++){
                if(vault.isCorrectPassword(i)){
                    System.out.println(this.getName()+" guessed the password "+i);
                    System.exit(0);
                }
            }
        }
    }

    private static class DescendingHacker extends HackerClass{

        public DescendingHacker(Vault vault) {
            super(vault);
        }

        @Override
        public void run(){
            for(int i=MAX_PASSWORD;i>=0;i--){
                if(vault.isCorrectPassword(i)){
                    System.out.println(this.getName()+" guessed the password "+i);
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread{
        @Override
        public void run(){
            for(int i=10;i>0;i--){
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e1){}
                System.out.println("Game over for Hackers");
                System.exit(0);
            }
        }
    }
}


