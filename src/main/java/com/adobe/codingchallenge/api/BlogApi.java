package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/post")
public class BlogApi {


//    @RequestMapping(value = "/saveBlog", method ={RequestMethod.POST}, produces = "application/json")
//    public void saveBlog(@Valid @RequestBody BlogReq blog){
//        System.out.println("This User" + blog);
//
//    }


    @RequestMapping(value = "/publishBlog", method ={RequestMethod.POST}, produces = "application/json")
    public void publishBlog(@Valid @RequestBody BlogReq blog){
        System.out.println("This User" + blog);

    }

    @RequestMapping(value = "/deleteBlog", method ={RequestMethod.DELETE}, produces = "application/json")
    public void deleteBlog(@Valid @RequestBody int blogId){
        System.out.println("This User" + blogId);
    }


}
