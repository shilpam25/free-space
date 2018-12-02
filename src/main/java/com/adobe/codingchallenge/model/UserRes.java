package com.adobe.codingchallenge.model;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class UserRes implements Serializable {

    @NotBlank(message = "user Email should not be empty")
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
