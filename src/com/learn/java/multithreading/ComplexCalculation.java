package com.learn.java.multithreading;

import java.math.BigInteger;

public class ComplexCalculation {
    public static void main(String[] args) throws InterruptedException {
        BigInteger res=calculateResult(BigInteger.TEN,BigInteger.ONE,BigInteger.TEN,BigInteger.ZERO);
        System.out.println(res);
    }
    public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result;
        PowerCalculatingThread t1= new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread t2= new PowerCalculatingThread(base2, power2);
        t1.start();
        t2.start();
        t1.join();
        result=t1.getResult().add(t2.getResult());
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            result = BigInteger.ONE;

            for(BigInteger i = BigInteger.ZERO;
                i.compareTo(power) !=0;
                i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
        }

        public BigInteger getResult() { return result; }
    }
}
