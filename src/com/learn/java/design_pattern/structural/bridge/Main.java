package com.learn.java.design_pattern.structural.bridge;

public class Main {
    public static void main(String[] args) {
        Payment order= new CardPayment();
        order._IPaymentSystem=new CitiBankPaymentSystem();
        order.makePayment();
         order._IPaymentSystem = new IdbiBankPaymentSystem();
         order.makePayment();
    }
}
