package com.adobe.codingchallenge.model;

import javax.validation.constraints.NotNull;

public class CommentReq {
    @NotNull(message = "Comment Description should not be empty")
    private String commentDes;
    private int blogId;
    private long userId;

    public String getCommentDes() {
        return commentDes;
    }

    public void setCommentDes(String commentDes) {
        this.commentDes = commentDes;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
