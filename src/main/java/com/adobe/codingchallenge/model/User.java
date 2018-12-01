package com.adobe.codingchallenge.model;

import org.hibernate.validator.constraints.NotBlank;

public class User {


    @NotBlank(message = "user name should not be empty")
    private String userId;
    @NotBlank(message = "password cannot be empty")
    private String pwd;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


}
