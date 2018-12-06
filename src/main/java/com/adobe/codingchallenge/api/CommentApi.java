package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.model.Comment;
import com.adobe.codingchallenge.model.CommentRes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

@Controller
public class CommentApi {

    @RequestMapping(value = "/user/{userId}/blog/{blogId}", method ={RequestMethod.POST}, produces = "application/json")
    public void postComment(@Valid @RequestBody Comment comment, @PathVariable("userId") @NotNull String userId, @PathVariable("blogId") @NotNull String blogId){

    }

    @RequestMapping(value = "/comment/{userId}", method ={RequestMethod.DELETE}, produces = "application/json")
    public void deleteAllCommentByUser(@PathVariable("userId") @NotNull String userId){

    }


    @RequestMapping(value = "/comment/{blogId}", method ={RequestMethod.DELETE}, produces = "application/json")
    public void deleteAllCommentByBlog(@PathVariable("blogId") @NotNull String blogId){

    }

    @RequestMapping(value = "/user/{userId}/comment/{commentId}", method ={RequestMethod.DELETE}, produces = "application/json")
    public void deleteCommentByUser(@PathVariable("userId") @NotNull String userId, @PathVariable("commentId") @NotNull String commentId){

    }

    @RequestMapping(value = "/comment/{userId}", method ={RequestMethod.GET}, produces = "application/json")
    public CommentRes getAllCommentByUser(@PathVariable("userId") @NotNull String userId){
    return null;
    }

    @RequestMapping(value = "/comment/{blogId}", method ={RequestMethod.GET}, produces = "application/json")
    public CommentRes getAllCommentByBlog(@PathVariable("blogId") @NotNull String blogId){
     return null;
    }

}
