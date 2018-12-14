package com.adobe.codingchallenge.repository.comment;

import com.adobe.codingchallenge.model.Comment;
import com.adobe.codingchallenge.model.CommentDetails;
import com.adobe.codingchallenge.model.CommentRes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAllByBlogId(long blogId);
    List<Comment> findAllByUserId(long userId);
    List<Comment> findAllByUserIdAndBlogId(long userId, long blogId);
    Comment findByUserIdAndCommentId(long userId, long commentId);

}
