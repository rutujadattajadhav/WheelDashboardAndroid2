package com.railway.wheeldashboard.login;


public class LoginRequest {
    private String email;
    private String passWord;

    // Constructor
    public LoginRequest(String email, String password) {
        this.email = email;
        this.passWord = password;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }
}
