package com.adobe.codingchallenge.repository.comment;

import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.CommentReq;

import java.util.List;

public interface CommentRepositoryDao {
    void submitComment(CommentReq comment, int blogId, int userId);
    List<CommentReq> retreiveAll();
}
