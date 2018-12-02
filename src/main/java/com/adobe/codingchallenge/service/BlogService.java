package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.BlogReq;

import java.util.List;

public interface BlogService {
    BlogReq saveBlog(BlogReq blog);
    void publishBlog(BlogReq blog);
    List<BlogReq> getBlogs();
    void deleteBlog(int blogId);
}
