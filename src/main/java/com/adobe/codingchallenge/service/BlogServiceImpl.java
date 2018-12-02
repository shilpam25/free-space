package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.Blog;
import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.repository.blog.BlogRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepositoryDao blogRepositoryDao;

    @Override
    public BlogReq saveBlog(BlogReq blog) {
        return null;
    }

    @Override
    public void publishBlog(BlogReq blog) {

    }

    @Override
    public List<BlogReq> getBlogs() {
        return null;
    }

    @Override
    public void deleteBlog(int blogId) {

    }
}
