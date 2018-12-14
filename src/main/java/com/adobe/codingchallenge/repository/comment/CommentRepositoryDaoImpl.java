package com.adobe.codingchallenge.repository.comment;

import com.adobe.codingchallenge.model.*;
import com.adobe.codingchallenge.repository.blog.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EnableTransactionManagement
@EnableJpaRepositories("com.adobe.codingchallenge.repository")
public class CommentRepositoryDaoImpl implements CommentRepositoryDao {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void submitComment(CommentReq commentReq) {
        Comment comment = new Comment();
        comment.setCretDt(new Date(System.currentTimeMillis()));
        comment.setCommentDesc(commentReq.getCommentDes());
        comment.setBlogId(commentReq.getBlogId());
        comment.setUserId(commentReq.getUserId());
        commentRepository.save(comment);
    }

    @Override
    public List<CommentDetails> retreiveAllByBlog(long blogId)
    {
        return generateCommentDetailsList(commentRepository.findAllByBlogId(blogId));
    }

    @Override
    public List<CommentDetails> retreiveAllByUser(long userId) {
        return generateCommentDetailsList(commentRepository.findAllByUserId(userId));
    }

    @Override
    public List<CommentDetails> retreiveAllByUserOnBlog(long userId, long blogId) {
        return generateCommentDetailsList(commentRepository.findAllByUserIdAndBlogId(userId, blogId));
    }

    @Override
    public void deleteComment(long commentId) {
        commentRepository.delete(commentId);

    }

    @Override
    public CommentDetails findByUserIdAndCommentId(long userId, long commentId) {

       return commentDetailsConverter(commentRepository.findByUserIdAndCommentId(userId, commentId));

    }

    private List<CommentDetails> generateCommentDetailsList(List<Comment> commentList)
    {
        List<CommentDetails> commentDetailsList = new ArrayList<>();
        for(int i = 0; i< commentList.size();i++){
            commentDetailsList.add(commentDetailsConverter(commentList.get(i)));
        }
        return commentDetailsList;
    }

    private CommentDetails commentDetailsConverter(Comment comment){
        CommentDetails commentDetails = new CommentDetails();
        commentDetails.setCommentDesc(comment.getCommentDesc());
        commentDetails.setCommentId(comment.getCommentId());
//        commentDetails.setCretDt(comment.getCretDt());
//        commentDetails.setInactvDt(comment.getInactvDt());
//        commentDetails.setUpdtDt(comment.getUpdtDt());
    return commentDetails;
    }

}
