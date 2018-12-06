package com.adobe.codingchallenge.repository.comment;

import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.CommentReq;
import com.adobe.codingchallenge.model.CommentRes;

import java.util.List;

public interface CommentRepositoryDao {
    void submitComment(CommentReq comment);
    List<CommentRes> retreiveAllByBlog(int blogId);
    List<CommentRes> retreiveAllByUser(int userId);
    List<CommentRes> retreiveAllByUserOnBlog(int userId, int blogId);
    void deleteComment(long commentId);
}
