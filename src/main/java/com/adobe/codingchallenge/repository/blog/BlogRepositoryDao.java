package com.adobe.codingchallenge.repository.blog;

import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.BlogRes;

import java.util.List;

public interface BlogRepositoryDao {
    BlogRes createBlog(BlogReq blog);
    void publishBlog(int blogId);
    void updateBlog(BlogReq blogReq);
    List<BlogRes> retreiveAll();
    BlogRes findBlogByBlogId(int blogId);
    List<BlogRes> findAllByUserId(long userId);
    BlogRes findBlogByBlogIdAndAndUserId(int blogId, long userID);
    void removeBlog(int blogId, long userId);
}
