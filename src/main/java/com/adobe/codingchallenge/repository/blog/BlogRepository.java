package com.adobe.codingchallenge.repository.blog;

import com.adobe.codingchallenge.model.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog, Long> {
}
