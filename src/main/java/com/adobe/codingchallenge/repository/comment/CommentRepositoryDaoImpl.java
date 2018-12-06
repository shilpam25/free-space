package com.adobe.codingchallenge.repository.comment;

import com.adobe.codingchallenge.model.*;
import com.adobe.codingchallenge.repository.blog.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;
import java.util.List;

@EnableTransactionManagement
@EnableJpaRepositories("com.adobe.codingchallenge.repository")
public class CommentRepositoryDaoImpl implements CommentRepositoryDao {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void submitComment(CommentReq commentReq){
        Comment comment = new Comment();
        comment.setCretDt(new Date(System.currentTimeMillis()));
        comment.setCommentDesc(commentReq.getComment());
        comment.setBlogId(commentReq.getBlogId());
        comment.setUserId(commentReq.getUserId());
        commentRepository.save(comment);
    }

    @Override
    public List<CommentRes> retreiveAllByBlog(int blogId){
        return commentRepository.findAllByBlogId(blogId);
    }
    public List<CommentRes> retreiveAllByUser(int userId){
        return commentRepository.findAllByUserId(userId);
    }
    public List<CommentRes> retreiveAllByUserOnBlog(int userId, int blogId){
        return commentRepository.findAllByUserIdAndBlogId(userId, blogId);
    }
    public  void deleteComment(long commentId){
        commentRepository.delete(commentId);
    }
}
