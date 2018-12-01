package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.model.Comment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentApi {
    @RequestMapping(value = "/publishComment", method ={RequestMethod.POST}, produces = "application/json")
    public void postComment(@Valid @RequestBody Comment comment){
        System.out.println("This User" + comment);

    }

    @RequestMapping(value = "/deleteComment", method ={RequestMethod.DELETE}, produces = "application/json")
    public void deleteComment(){
        System.out.println("This User");

    }

    @RequestMapping(value = "/getComment", method ={RequestMethod.GET}, produces = "application/json")
    public void getComment(){
        System.out.println("This User");

    }

}
