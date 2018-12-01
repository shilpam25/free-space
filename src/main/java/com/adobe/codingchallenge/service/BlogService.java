package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.Blog;

import java.util.List;

public interface BlogService {
    Blog saveBlog(Blog blog);
    void publishBlog(Blog blog);
    List<Blog> getBlogs();
    void deleteBlog(int blogId);
}
