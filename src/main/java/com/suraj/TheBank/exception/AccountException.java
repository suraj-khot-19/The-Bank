package com.suraj.TheBank.exception;

/// exception class for handling error related account
public class AccountException extends RuntimeException {
    public AccountException(String message) {
        super(message);
    }
}
