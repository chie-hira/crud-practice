package com.raisetech.servicepractice.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){super(message);
    }
}
