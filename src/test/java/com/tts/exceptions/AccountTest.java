package com.tts.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    private Account account;

    @Test
    public void checkDepositFromCtor() {
        account = new Account(100);
        assertEquals(100.0, account.getBalance(), 0.01);
    }

    @Test
    public void deposit() {
        account = new Account(100);
        double newBalance = account.deposit(50);
        assertEquals(150.0, newBalance, 0.01);
        assertEquals(150.0, account.getBalance(), 0.01);
    }

    @Test
    public void withdraw() {
        account = new Account(100);
        double newBalance = account.withdraw(25);
        assertEquals(75.0, newBalance, 0.01);
        assertEquals(75.0, account.getBalance(), 0.01);
    }

    @Test(expected = InsufficientFundsException.class)
    public void overdrawnAccount() {
        account = new Account(100);
        double newBalance = account.withdraw(101);
    }
}