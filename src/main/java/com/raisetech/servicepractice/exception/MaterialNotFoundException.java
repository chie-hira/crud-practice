package com.raisetech.servicepractice.exception;

import org.springframework.http.HttpStatus;

public class MaterialNotFoundException extends RuntimeException{
    private HttpStatus status;

    public MaterialNotFoundException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
