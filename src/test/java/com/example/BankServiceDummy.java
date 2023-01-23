package com.example;

public class BankServiceDummy implements BankService{
    public boolean payIsCalled = false;
    public int count;
    @Override
    public void pay(String id, double amount) {
        payIsCalled = true;
        count++;
    }
}
