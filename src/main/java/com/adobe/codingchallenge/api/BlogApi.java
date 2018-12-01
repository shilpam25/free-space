package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/post")
public class BlogApi {


    @RequestMapping(value = "/saveBlog", method ={RequestMethod.POST}, produces = "application/json")
    public void saveBlog(@Valid @RequestBody User user){
        System.out.println("This User" + user);

    }


    @RequestMapping(value = "/publishBlog", method ={RequestMethod.PUT}, produces = "application/json")
    public void publishBlog(@Valid @RequestBody User user){
        System.out.println("This User" + user);

    }


    @RequestMapping(value = "/deleteBlog", method ={RequestMethod.DELETE}, produces = "application/json")
    public void deleteBlog(@Valid @RequestBody User user){
        System.out.println("This User" + user);

    }

}
