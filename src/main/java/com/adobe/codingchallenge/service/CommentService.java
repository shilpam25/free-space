package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.Comment;

public interface CommentService {
    Comment postComment(Comment comment);
    void deleteComment(int commentId);
}
