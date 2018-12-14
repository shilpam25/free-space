package com.adobe.codingchallenge.repository.blog;

import com.adobe.codingchallenge.model.Blog;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BlogRepository extends CrudRepository<Blog, Long> {

    List<Blog> findBlogByInactvDtNull();
    Blog findBlogByBlogId(int blogId);
    List<Blog> findAllByUserId(long userId);
    Blog findBlogByBlogIdAndAndUserId(int blogId, long userID);
    List<Blog> findAllByCretDtOrderByCretDtDesc(long userId);


}
