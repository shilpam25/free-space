package com.adobe.codingchallenge.repository.blog;

import com.adobe.codingchallenge.model.*;
import com.adobe.codingchallenge.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@EnableTransactionManagement
@EnableJpaRepositories("com.adobe.codingchallenge.repository")
public class BlogRepositoryDaoImpl implements BlogRepositoryDao {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public BlogRes createBlog(BlogReq blog, long userId){
        Blog blogTemp = new Blog();
        blogTemp.setCretDt(new Date(System.currentTimeMillis()));
        blogTemp.setUpdtDt(new Date(System.currentTimeMillis()));
        blogTemp.setInactvDt(new Date(System.currentTimeMillis()));
        blogTemp.setTitle(blog.getTitle());
        blogTemp.setDesc(blog.getDesc());
        blogTemp.setUserId(userId);
        Blog blogResult= blogRepository.save(blogTemp);
        if(blogResult !=null){
            return createBlogRes(blogResult);}
        return null;
    }
    @Override
    public void publishBlog(int blogId){
        Blog blog = blogRepository.findBlogByBlogId(blogId);
        if(blog == null)
            throw new NoSuchElementException("Blog not found");
        blog.setInactvDt(null);
        blogRepository.save(blog);
    }

    @Override
    public void updateBlog(BlogReq blogRe){
            Blog blogTemp = blogRepository.findBlogByBlogId(blogRe.getBlogId());
            blogTemp.setUpdtDt(new Date(System.currentTimeMillis()));
            blogTemp.setTitle(blogRe.getTitle());
            blogTemp.setDesc(blogRe.getDesc());
            blogRepository.save(blogTemp);
    }


    @Override
    public void removeBlog(int blogId, long userId){
        Blog blog = blogRepository.findBlogByBlogIdAndAndUserId(blogId, userId);
        if (blog != null)
        blogRepository.delete(blog);
        else{
            throw new NoSuchElementException("user Blog not found"); }
    }


    @Override
    public List<BlogRes> retreiveAll(){
       List<Blog> blogList;
       List<BlogRes> blogResList = new ArrayList<BlogRes>();
       blogList= blogRepository.findBlogByInactvDtNull();
        if (blogList.size()>0) {
            for (int i = 0; i < blogList.size(); i++) {
                blogResList.add(createBlogRes(blogList.get(i)));
            }
            return blogResList;
        }
        return null;
    }
    @Override
    public BlogRes findBlogByBlogId(int blogId){
        Blog blogResult = blogRepository.findBlogByBlogId(blogId);
        return createBlogRes(blogResult);
    }

    @Override
    public List<BlogRes> findAllByUserId(long userId){
        List<Blog> blogList;
        List<BlogRes> blogResList = new ArrayList<BlogRes>();
        blogList= blogRepository.findAllByUserId(userId);
        if (blogList.size()>0) {
            for (int i = 0; i < blogList.size(); i++) {
                blogResList.add(createBlogRes(blogList.get(i)));
            }
            return blogResList;
        }
        return null;
        }


    @Override
    public BlogRes findBlogByBlogIdAndAndUserId(int blogId, long userId){
        Blog blogResult = blogRepository.findBlogByBlogIdAndAndUserId(blogId, userId);
        return createBlogRes(blogResult);
    }

    private BlogRes createBlogRes(Blog blog){
        BlogRes blogRes = new BlogRes();
        blogRes.setBlogId(blog.getBlogId());
        UserRes userRes= new UserRes();
        userRes.setUserId(blog.getUserId());
        blogRes.setUserRes(userRes);
        blogRes.setTitle(blog.getTitle());
        blogRes.setDesc(blog.getDesc());
        blogRes.setCretDt(blog.getCretDt());
        return blogRes;
    }




}
