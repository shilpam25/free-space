package com.adobe.codingchallenge.repository.comment;

import com.adobe.codingchallenge.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
