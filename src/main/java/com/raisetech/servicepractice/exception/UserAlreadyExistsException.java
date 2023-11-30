package com.raisetech.servicepractice.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message){super(message);}
}
