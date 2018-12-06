package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.Blog;
import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.BlogRes;
import com.adobe.codingchallenge.model.UserRes;
import com.adobe.codingchallenge.repository.blog.BlogRepositoryDao;
import com.adobe.codingchallenge.repository.user.UserRepository;
import com.adobe.codingchallenge.repository.user.UserRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepositoryDao blogRepositoryDao;

    @Autowired
    UserRepositoryDao userRepositoryDao;

    @Override
    public BlogRes saveBlog(BlogReq blog, int userId) {
        BlogRes blogRes;
        blogRes= blogRepositoryDao.createBlog(blog, userId);
        return blogRes;
    }

    @Override
    public void publishBlog(int blogId) {
        blogRepositoryDao.publishBlog(blogId);
    }

    @Override
    public void updateBlog(BlogReq blog){
        blogRepositoryDao.updateBlog(blog);
    }

    @Override
    public List<BlogRes> getBlogs() {
        return blogRepositoryDao.retreiveAll(); //TODO send only latest 10 for landing page

    }

    @Override
    public void deleteBlog(int blogId, long userId) {
        blogRepositoryDao.removeBlog(blogId, userId);
    }
    //TODO
    @Override
    public List<BlogRes> getLatest10(){

     return null;
    }
    @Override
    public BlogRes getBlogDetails(int blogId){
        BlogRes blogRes = blogRepositoryDao.findBlogByBlogId(blogId);
        long userId= blogRes.getUserRes().getUserId();
        UserRes userRes= userRepositoryDao.getUserDetails(userId);
        blogRes.setUserRes(userRes);
        return blogRes;
    }
    @Override
    public BlogRes getBlodDetailsbyUser(int blogId, long userId){
        return null;
    }
    @Override
    public List<BlogRes> getAllBlogByUser(long userId){
        return blogRepositoryDao.findAllByUserId(userId);

    }
}
