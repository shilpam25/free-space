package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.BlogRes;
import com.adobe.codingchallenge.model.User;
import com.adobe.codingchallenge.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class BlogApi {
@Autowired
    BlogService blogService;

    @RequestMapping(value = "/saveBlog", method ={RequestMethod.POST}, produces = "application/json")
    public BlogRes saveBlog(@RequestParam(value = "userId") int userId, @Valid @RequestBody BlogReq blog){
        return blogService.saveBlog(blog, userId);

    }


    @RequestMapping(value = "/fetchLatest10", method ={RequestMethod.GET}, produces = "application/json")
    public List<BlogRes> fetchLatest10(){
       return blogService.getBlogs();

    }

    @RequestMapping(value = "/deleteBlog", method ={RequestMethod.DELETE}, produces = "application/json")
    public void deleteBlog(@Valid @RequestBody int blogId){
        System.out.println("This User" + blogId);
    }


}
