package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.Comment;
import com.adobe.codingchallenge.model.CommentReq;
import com.adobe.codingchallenge.model.CommentRes;
import com.adobe.codingchallenge.repository.comment.CommentRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepositoryDao commentRepositoryDao;
    @Override
    public void postComment(CommentReq comment){
        commentRepositoryDao.submitComment(comment);
    }
    @Override
    public void deleteComment(int commentId){
        commentRepositoryDao.deleteComment(commentId);
    }
    @Override
    public List<CommentRes> retreiveAllByBlog(int blogId){
        return commentRepositoryDao.retreiveAllByBlog(blogId);
    }
    @Override
    public List<CommentRes> retreiveAllByUser(int userId){
        return commentRepositoryDao.retreiveAllByUser(userId);
    }
    @Override
    public List<CommentRes> retreiveAllByUserOnBlog(int userId, int blogId){
        return commentRepositoryDao.retreiveAllByUserOnBlog(userId, blogId);
    }
}
