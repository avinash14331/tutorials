package com.learn.java.design_pattern.structural.bridge;

public class IdbiBankPaymentSystem implements IPaymentSystem{
    @Override
    public void processPayment(String paymentSystem) {
        System.out.println("IDBI Bank for "+paymentSystem);
    }
}
