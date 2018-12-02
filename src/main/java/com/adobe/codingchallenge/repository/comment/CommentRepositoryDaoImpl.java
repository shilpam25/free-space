package com.adobe.codingchallenge.repository.comment;

import com.adobe.codingchallenge.model.Blog;
import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.Comment;
import com.adobe.codingchallenge.model.CommentReq;
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
    public void submitComment(CommentReq commentReq, int blogId, int userId){
        Comment comment = new Comment();
        //user.setUserId(new BigInteger("1234"));
        comment.setCretDt(new Date(System.currentTimeMillis()));
        comment.setCommentDesc(commentReq.getComment());
        comment.setBlogId(blogId);
        comment.setUserId(userId);
        commentRepository.save(comment);
    }

    @Override
    public List<CommentReq> retreiveAll(){
        return null;
    }
}
