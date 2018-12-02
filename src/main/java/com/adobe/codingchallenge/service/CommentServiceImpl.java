package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.Comment;
import com.adobe.codingchallenge.repository.comment.CommentRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepositoryDao commentRepositoryDao;
    @Override
    public Comment postComment(Comment comment){


        return null;
    }
    @Override
    public void deleteComment(int commentId){

    }
}
