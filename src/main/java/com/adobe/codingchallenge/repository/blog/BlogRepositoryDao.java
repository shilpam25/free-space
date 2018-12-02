package com.adobe.codingchallenge.repository.blog;

import com.adobe.codingchallenge.model.BlogReq;

import java.util.List;

public interface BlogRepositoryDao {
    void createBlog(BlogReq blog);
     List<BlogReq> retreiveAll();
}
