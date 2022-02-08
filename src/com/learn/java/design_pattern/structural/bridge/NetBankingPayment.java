package com.learn.java.design_pattern.structural.bridge;

public class NetBankingPayment extends Payment{
    @Override
    public void makePayment() {
        _IPaymentSystem.processPayment("NetBanking payment");
    }
}
