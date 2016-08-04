package com.theironyard.charlotte;

/**
 * Created by mfahrner on 8/4/16.
 */
public class Person {
    private String name;
    private double accountBalance;

    public Person(String name, double accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }



}
