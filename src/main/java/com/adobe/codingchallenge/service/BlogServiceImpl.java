package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.Blog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogServiceImpl implements BlogService {
    @Override
    public Blog saveBlog(Blog blog){
        return null;
    }
    @Override
    public void publishBlog(Blog blog){

    }
    @Override
    public List<Blog> getBlogs(){
      return null;
    }
    @Override
    public void deleteBlog(int blogId){

    }
}
