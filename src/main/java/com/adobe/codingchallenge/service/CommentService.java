package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.CommentDetails;
import com.adobe.codingchallenge.model.CommentReq;

import java.util.List;

public interface CommentService {
    void postComment(CommentReq comment);
    void deleteComment(long commentId, long userId);
    void deleteAllCommentByUser(long userId);
    void deleteAllCommentByBlog(long blogId);
    List<CommentDetails> retreiveAllByBlog(long blogId);
    List<CommentDetails> retreiveAllByUser(long userId);
    List<CommentDetails> retreiveAllByUserOnBlog(long userId, long blogId);
}
