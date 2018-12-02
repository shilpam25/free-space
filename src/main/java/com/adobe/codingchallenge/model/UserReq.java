package com.adobe.codingchallenge.model;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class UserReq implements Serializable {

    @NotBlank(message = "user Email should not be empty")
    private String userEmail;
    @NotBlank(message = "password cannot be empty")
    private String pwd;


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userId) {
        this.userEmail = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
