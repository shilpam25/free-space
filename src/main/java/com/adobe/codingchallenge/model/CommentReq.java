package com.adobe.codingchallenge.model;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class CommentReq implements Serializable {

    @NotBlank(message = "Comment should not be empty")
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
