package com.tts.exceptions;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException() {
        this("Nope. Not enough cashy money");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
