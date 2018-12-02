package com.adobe.codingchallenge.repository.blog;

import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.BlogRes;

import java.util.List;

public interface BlogRepositoryDao {
    BlogRes createBlog(BlogReq blog, int userId);
     List<BlogRes> retreiveAll();
}
