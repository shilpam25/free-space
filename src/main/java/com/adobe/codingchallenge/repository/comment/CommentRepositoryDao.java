package com.adobe.codingchallenge.repository.comment;

import com.adobe.codingchallenge.model.CommentDetails;
import com.adobe.codingchallenge.model.CommentReq;

import java.util.List;

public interface CommentRepositoryDao {
    void submitComment(CommentReq comment);
    List<CommentDetails> retreiveAllByBlog(long blogId);
    List<CommentDetails> retreiveAllByUser(long userId);
    List<CommentDetails> retreiveAllByUserOnBlog(long userId, long blogId);
    CommentDetails findByUserIdAndCommentId(long userId, long commentId);
    void deleteComment(long commentId);
}
