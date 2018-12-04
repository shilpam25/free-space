package com.adobe.codingchallenge.model;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class CommentReq implements Serializable {

    @NotBlank(message = "Comment should not be empty")
    private String comment;
    @NotBlank(message = "BlogID should not be empty")
    private int blogId;
    @NotBlank(message = "UserId should not be empty")
    private int userId;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
