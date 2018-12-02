package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.BlogRes;

import java.util.List;

public interface BlogService {
    BlogRes saveBlog(BlogReq blog, int userId);
    void publishBlog(BlogReq blog);
    List<BlogRes> getBlogs();
    void deleteBlog(int blogId);
}
