package com.raisetech.servicepractice.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserRequest {
    @NotNull
    @NotBlank(message = "name is required")
    private String name;
    @NotNull
    @NotBlank(message = "email is required")
    private String email;

    public UserRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
