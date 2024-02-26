package com.aby.dto;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String username;
    private String password;

    // Constructors, getters, and setters

    public UserLoginRequest() {
    }

    public UserLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
}
