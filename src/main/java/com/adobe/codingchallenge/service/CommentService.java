package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.Comment;
import com.adobe.codingchallenge.model.CommentReq;
import com.adobe.codingchallenge.model.CommentRes;

import java.util.List;

public interface CommentService {
    void postComment(CommentReq comment);
    void deleteComment(int commentId);
    List<CommentRes> retreiveAllByBlog(int blogId);
    List<CommentRes> retreiveAllByUser(int userId);
    List<CommentRes> retreiveAllByUserOnBlog(int userId, int blogId);
}
