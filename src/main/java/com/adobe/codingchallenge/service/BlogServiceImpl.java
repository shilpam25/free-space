package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.Blog;
import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.BlogRes;
import com.adobe.codingchallenge.repository.blog.BlogRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepositoryDao blogRepositoryDao;

    @Override
    public BlogRes saveBlog(BlogReq blog, int userId) {
        BlogRes blogRes;
        blogRes= blogRepositoryDao.createBlog(blog, userId);
        return blogRes;
    }

    @Override
    public void publishBlog(BlogReq blog) {

    }

    @Override
    public List<BlogRes> getBlogs() {
        return blogRepositoryDao.retreiveAll();

    }

    @Override
    public void deleteBlog(int blogId) {

    }
}
