package com.example.employee.dto;

public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
        System.out.println(token);
    }

    public String getToken() {
        return token;
    }
}
