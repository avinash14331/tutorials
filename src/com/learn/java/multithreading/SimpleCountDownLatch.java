package com.learn.java.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleCountDownLatch {
    private int count;

    public SimpleCountDownLatch(int count) {
        this.count = count;
        if (count < 0) {
            throw new IllegalArgumentException("count cannot be negative");
        }
    }

    /**
     * Causes the current thread to wait until the latch has counted down to zero.
     * If the current count is already zero then this method returns immediately.
     */
    public void await() throws InterruptedException {
        /**
         * Fill in your code
         */
        synchronized (this) {
            while (count > 0) {
                this.wait();
            }
        }
    }

    /**
     * Decrements the count of the latch, releasing all waiting threads if the count reaches zero.
     * If the current count equals zero then nothing happens.
     */
    public void countDown() throws InterruptedException {
        /**
         * Fill in your code
         */
        synchronized (this) {
            if (count > 0) {
                count--;
            }

            if (count == 0) {
                this.notifyAll();
            }
        }


    }

    /**
     * Returns the current count.
     */
    public int getCount() {
        /**
         * Fill in your code
         */
        synchronized (this) {
            return this.count;
        }
    }
}

