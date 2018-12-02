package com.adobe.codingchallenge.repository.blog;

import com.adobe.codingchallenge.model.Blog;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface BlogRepository extends CrudRepository<Blog, Long> {

    List<Blog> findAll();


}
