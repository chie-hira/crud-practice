package com.raisetech.servicepractice.controller;

public class UserResponse {
    private String message;

    public UserResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
