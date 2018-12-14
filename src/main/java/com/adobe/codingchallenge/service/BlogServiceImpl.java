package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.*;
import com.adobe.codingchallenge.repository.blog.BlogRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepositoryDao blogRepositoryDao;

    @Autowired
    CommentService commentService;

    @Override
    public BlogRes saveBlog(BlogReq blog) {
        BlogRes blogRes;
        blogRes= blogRepositoryDao.createBlog(blog);
        return blogRes; }

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
        return addCommentResListToBlogList(blogRepositoryDao.retreiveAll()); //TODO send only latest 10 for landing page
    }

    @Override
    public void deleteBlog(int blogId, long userId) {
        commentService.deleteAllCommentByBlog(blogId);
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
        List<CommentDetails> commentDetailsList = commentService.retreiveAllByBlog(blogRes.getBlogId());
        if( commentDetailsList.size() != 0){
            blogRes.setCommentResList(commentDetailsList);}
        return blogRes;
    }
    @Override
    public BlogRes getBlogDetailsbyUser(int blogId, long userId){
        return null;
    }
    @Override
    public List<BlogRes> getAllBlogByUser(long userId){
        return addCommentResListToBlogList(blogRepositoryDao.findAllByUserId(userId)); //TODO send only latest 10 for landing page
    }

    private List<BlogRes> addCommentResListToBlogList(List<BlogRes> blogResList){
        for (int i = 0; i<blogResList.size(); i++){
            List<CommentDetails> commentDetailsList = commentService.retreiveAllByBlog(blogResList.get(i).getBlogId());
            if( commentDetailsList.size() != 0){
                blogResList.get(i).setCommentResList(commentDetailsList);}
        }
        return blogResList;
    }
}
