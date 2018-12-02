package com.adobe.codingchallenge.repository.blog;

import com.adobe.codingchallenge.model.*;
import com.adobe.codingchallenge.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EnableTransactionManagement
@EnableJpaRepositories("com.adobe.codingchallenge.repository")
public class BlogRepositoryDaoImpl implements BlogRepositoryDao {

    @Autowired
    BlogRepository blogRepository;
    @Override
    public BlogRes createBlog(BlogReq blog, int userId){
        BlogRes blogRes = new BlogRes();
        Blog blogTemp = new Blog();
        blogTemp.setCretDt(new Date(System.currentTimeMillis()));
        blogTemp.setTitle(blog.getTitle());
        blogTemp.setDesc(blog.getDesc());
        blogTemp.setUserId(userId);
        Blog blogResult= blogRepository.save(blogTemp);
        if(blogResult !=null){
        blogRes.setBlogId(blogResult.getBlogId());
        return blogRes;}
        return null;
    }

    @Override
    public List<BlogRes> retreiveAll(){
       List<Blog> blogList;
       List<BlogRes> blogResList = new ArrayList<BlogRes>();
       blogList= blogRepository.findAll();
       if (blogList.size()>0){
           for (int i = 0; i<blogList.size();i++){
               BlogRes blogRes = new BlogRes();
               blogRes.setBlogId(blogList.get(i).getBlogId());
               blogRes.setUserId(blogList.get(i).getUserId());
               blogRes.setTitle(blogList.get(i).getTitle());
               blogRes.setDesc(blogList.get(i).getDesc());
               blogRes.setCretDt(blogList.get(i).getCretDt());
               blogResList.add(blogRes);
           }
           return blogResList;
       }

       return null;
    }
}
