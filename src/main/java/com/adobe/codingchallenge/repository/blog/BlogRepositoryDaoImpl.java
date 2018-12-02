package com.adobe.codingchallenge.repository.blog;

import com.adobe.codingchallenge.model.Blog;
import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.User;
import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;
import java.util.List;

@EnableTransactionManagement
@EnableJpaRepositories("com.adobe.codingchallenge.repository")
public class BlogRepositoryDaoImpl implements BlogRepositoryDao {

    @Autowired
    BlogRepository blogRepository;
    @Override
    public void createBlog(BlogReq blog){
        Blog blogTemp = new Blog();
        //user.setUserId(new BigInteger("1234"));
        blogTemp.setCretDt(new Date(System.currentTimeMillis()));
        blogTemp.setTitle(blog.getTitle());
        blogTemp.setDesc(blog.getDesc());
        blogRepository.save(blogTemp);
    }

    @Override
    public List<BlogReq> retreiveAll(){
 return null;
    }
}
