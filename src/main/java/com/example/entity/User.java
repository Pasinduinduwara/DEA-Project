package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("email")
    private String email;
    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    @JsonProperty("role")
    private String role;


    public User() {}

    public User(String email, String userName, String password, String role) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
