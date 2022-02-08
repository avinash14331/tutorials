package com.learn.java.design_pattern.structural.bridge;

public abstract class Payment {
    IPaymentSystem _IPaymentSystem;
    public abstract void makePayment();
}
