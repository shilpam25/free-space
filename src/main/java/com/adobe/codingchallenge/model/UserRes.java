package com.adobe.codingchallenge.model;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class UserRes implements Serializable {

    private int userId;
    private String userEmail;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
