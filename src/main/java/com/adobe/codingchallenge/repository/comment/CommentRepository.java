package com.adobe.codingchallenge.repository.comment;

import com.adobe.codingchallenge.model.Comment;
import com.adobe.codingchallenge.model.CommentRes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<CommentRes> findAllByBlogId(int blogId);
    List<CommentRes> findAllByUserId(int userId);
    List<CommentRes> findAllByUserIdAndBlogId(int userId, int blogId);
}
