package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.BlogRes;
import com.adobe.codingchallenge.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BlogApi {
@Autowired
    BlogService blogService;

    @RequestMapping(value = "/user/{userId}/save-blog", method ={RequestMethod.POST}, consumes = {"application/json",MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {"application/json", MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public BlogRes saveBlog(@PathVariable ("userId") @NotNull String userId, @RequestBody @Valid  BlogReq blog, Model model){
        return blogService.saveBlog(blog, Integer.parseInt(userId));

    }

    @RequestMapping(value = "/latest/blogs", method ={RequestMethod.GET}, produces = "application/json")
    public List<BlogRes> getLatest10(){
       return blogService.getBlogs();

    }


    @RequestMapping(value = "/user/publish-blog/{blogId}", method ={RequestMethod.POST}, produces = "application/json")
    public BlogRes publishBlog(@PathVariable("blogId") @NotNull String blogId){
        return null;

    }

    @RequestMapping(value = "/user/{userId}/blogs", method ={RequestMethod.GET}, produces = "application/json")
    public List<BlogRes> getAllByUser(@PathVariable ("userId") @NotNull String userId){
        return blogService.getAllBlogByUser(Integer.parseInt(userId));

    }

    @RequestMapping(value = "/blogs", method ={RequestMethod.GET}, produces = "application/json")
    public List<BlogRes> getAll(){
        return blogService.getBlogs();

    }

    @RequestMapping(value = "/blog/{blogId}", method ={RequestMethod.GET}, consumes = {"application/json", MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {"application/json", MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public BlogRes getBlogDetails(@PathVariable("blogId") @NotNull String blogId, Model model){
        BlogRes blogRes = blogService.getBlogDetails(Integer.parseInt(blogId));
        model.addAttribute("blogObject", blogRes);
        return blogRes;

    }

    @RequestMapping(value = "/user/{userId}/blog/{blogId}", method ={RequestMethod.DELETE}, produces = "application/json")
    public void removeUserBlog(@PathVariable("userId") @NotNull String userId, @RequestParam("blogId") @NotNull String blogId){
        blogService.deleteBlog(Integer.parseInt(userId), Integer.parseInt(blogId));
    }
}
