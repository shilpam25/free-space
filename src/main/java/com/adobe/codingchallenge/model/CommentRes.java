package com.adobe.codingchallenge.model;

import java.util.List;

public class CommentRes {
    List<CommentDetails> commentDetailsList;

    public List<CommentDetails> getCommentDetailsList() {
        return commentDetailsList;
    }

    public void setCommentDetailsList(List<CommentDetails> commentDetailsList) {
        this.commentDetailsList = commentDetailsList;
    }
}
