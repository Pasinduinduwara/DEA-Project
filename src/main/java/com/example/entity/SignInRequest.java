package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignInRequest {
    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    public SignInRequest() {}

    public SignInRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
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

}
