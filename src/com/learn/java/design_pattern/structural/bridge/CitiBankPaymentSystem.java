package com.learn.java.design_pattern.structural.bridge;

public class CitiBankPaymentSystem implements IPaymentSystem{
    @Override
    public void processPayment(String paymentSystem) {
        System.out.println("Citi Bank for "+paymentSystem);
    }
}
