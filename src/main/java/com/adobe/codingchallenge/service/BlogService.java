package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.Blog;
import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.BlogRes;

import java.util.List;

public interface BlogService {
    BlogRes saveBlog(BlogReq blog);

    List<BlogRes> getLatest10();

    void publishBlog(int blogId);
    void updateBlog(BlogReq blog);
    List<BlogRes> getBlogs();
    void deleteBlog(int blogId, long userId);
    BlogRes getBlogDetails(int blogId);
    BlogRes getBlogDetailsbyUser(int blogId, long userId);
    List<BlogRes> getAllBlogByUser(long userId);
}
