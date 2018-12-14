package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.CommentDetails;
import com.adobe.codingchallenge.model.CommentReq;
import com.adobe.codingchallenge.repository.comment.CommentRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepositoryDao commentRepositoryDao;
    @Override
    public void postComment(CommentReq comment){
        commentRepositoryDao.submitComment(comment);
    }
    @Override
    public void deleteComment(long commentId, long userId)
    {
        CommentDetails commentRes= commentRepositoryDao.findByUserIdAndCommentId(userId, commentId);
        if(commentRes !=null){
        commentRepositoryDao.deleteComment(commentRes.getCommentId());}
        else{
            throw new NoSuchElementException("comment not found");
        }
    }
    @Override
    public List<CommentDetails> retreiveAllByBlog(long blogId){
        return commentRepositoryDao.retreiveAllByBlog(blogId);
    }
    @Override
    public List<CommentDetails> retreiveAllByUser(long userId){
        return commentRepositoryDao.retreiveAllByUser(userId);
    }
    @Override
    public List<CommentDetails> retreiveAllByUserOnBlog(long userId, long blogId){
        return commentRepositoryDao.retreiveAllByUserOnBlog(userId, blogId);
    }
    @Override
    public void deleteAllCommentByUser(long userId){
        List<CommentDetails> commentRes= commentRepositoryDao.retreiveAllByUser(userId);
        for (int i =0; i< commentRes.size();i++)
        {
            commentRepositoryDao.deleteComment(commentRes.get(i).getCommentId());
        }
    }
    @Override
    public void deleteAllCommentByBlog(long blogId){
        List<CommentDetails> commentRes= commentRepositoryDao.retreiveAllByBlog(blogId);
        for (int i =0; i< commentRes.size();i++)
        {
            commentRepositoryDao.deleteComment(commentRes.get(i).getCommentId());
        }
    }
}
