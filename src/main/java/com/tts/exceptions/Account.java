package com.tts.exceptions;

public class Account {
    private static int numAccounts;

    private int number = numAccounts++;
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        if (balance < amount)
            throw new InsufficientFundsException();
        balance -= amount;
        return balance;
    }
}
