package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.BlogRes;
import com.adobe.codingchallenge.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class BlogApi {
@Autowired
    BlogService blogService;

    @RequestMapping(value = "/user/{userId}/save-blog", method ={RequestMethod.POST}, produces = "application/json")
    public BlogRes saveBlog(@PathParam("userId") @NotNull String userId, @Valid @RequestBody BlogReq blog, Model model){
        return blogService.saveBlog(blog, Integer.parseInt(userId));

    }


    @RequestMapping(value = "/latest/blogs", method ={RequestMethod.GET}, produces = "application/json")
    public List<BlogRes> getLatest10(){
       return blogService.getBlogs();

    }


    @RequestMapping(value = "/user/publish-blog/{blogId}", method ={RequestMethod.POST}, produces = "application/json")
    public BlogRes publishBlog(@PathParam("blogId") @NotNull String blogId){
        return null;

    }

    @RequestMapping(value = "/user/{userId}/blogs", method ={RequestMethod.GET}, produces = "application/json")
    public List<BlogRes> getAllByUser(@PathParam("userId") @NotNull String userId){
        return null;

    }

    @RequestMapping(value = "/blogs", method ={RequestMethod.GET}, produces = "application/json")
    public List<BlogRes> getAll(){
        return null;

    }

    @RequestMapping(value = "/blog/{blogId}", method ={RequestMethod.GET}, produces = "application/json")
    public BlogRes getBlogDetails(@PathParam("blogId") @NotNull String blogId){
        return null;

    }

    @RequestMapping(value = "/user/{userId}/blog/{blogId}", method ={RequestMethod.DELETE}, produces = "application/json")
    public void removeUserBlog(@PathParam("userId") @NotNull String userId, @PathParam("blogId") @NotNull String blogId){

    }
}
