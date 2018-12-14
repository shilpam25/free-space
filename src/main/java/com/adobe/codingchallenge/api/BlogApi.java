package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.BlogRes;
import com.adobe.codingchallenge.model.GetBlogsRes;
import com.adobe.codingchallenge.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
public class BlogApi {
@Autowired
    BlogService blogService;


        @RequestMapping(value = "/user/save-blog", method ={RequestMethod.POST}, consumes = {"application/json"}, produces = {"application/json"})
    public @ResponseBody  BlogRes saveBlog(@RequestBody @Valid  BlogReq blog){
        BlogRes blogRes= blogService.saveBlog(blog);
        //model.addAttribute("blogRes", blogRes);
        //return "redirect:/";
      return blogRes;
    }

    @RequestMapping(value = "/latest/blogs", method ={RequestMethod.GET}, produces = "application/json")
    public @ResponseBody GetBlogsRes getLatest10(){
        GetBlogsRes getBlogsRes= new GetBlogsRes();
        getBlogsRes.setBlogRes(blogService.getBlogs());


       return getBlogsRes;

    }


    @RequestMapping(value = "/user/publish-blog/{blogId}", method ={RequestMethod.PUT}, produces = "application/json")
    public String publishBlog(@PathVariable("blogId") @NotNull String blogId){
        blogService.publishBlog(Integer.parseInt(blogId));
        //model.addAttribute("blogPublished",true);
        return "redirect:/";

    }


    @RequestMapping(value = "/blog/blogs", method ={RequestMethod.GET}, consumes = "application/json", produces = "application/json")
    public @ResponseBody GetBlogsRes getAll(){
        GetBlogsRes blogsRes = new GetBlogsRes();

        List<BlogRes> blogResList=  blogService.getBlogs();
        //model.addAttribute("blogList", blogResList);
        blogsRes.setBlogRes(blogResList);
        return blogsRes;
        //return "redirect:/blog/blogtemplate";
    }

    @RequestMapping(value = "/blog/blogDetails/{blogId}", method ={RequestMethod.GET}, consumes = {"application/json"}, produces = {"application/json"})
    public @ResponseBody BlogRes getBlogDetails(@PathVariable("blogId") String blogId){
        BlogRes blogRes = blogService.getBlogDetails(Integer.parseInt(blogId));
       // model.addAttribute("blogObject", blogRes);
        //return "blog/blogDetails";
     return blogRes;
    }

    @RequestMapping(value = "/user/{userId}/blog/{blogId}", method ={RequestMethod.DELETE}, produces = "application/json")
    public @ResponseBody void removeUserBlog(@PathVariable("userId") @NotNull String userId, @PathVariable("blogId") @NotNull String blogId){
        blogService.deleteBlog(Integer.parseInt(blogId), Integer.parseInt(userId));
        List<BlogRes> blogResList= blogService.getAllBlogByUser(Integer.parseInt(userId));
        //model.addAttribute("blogList", blogResList);
        //return "redirect:/";
    }
}
