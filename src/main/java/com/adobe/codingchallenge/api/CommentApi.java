package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.model.Comment;
import com.adobe.codingchallenge.model.CommentRes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

@Controller
public class CommentApi {
    @RequestMapping(value = "/user/{userId}/blog/{blogId}", method ={RequestMethod.POST}, produces = "application/json")
    public void postComment(@Valid @RequestBody Comment comment, @PathParam("userId") @NotNull String userId, @PathParam("blogId") @NotNull String blogId){

    }

    @RequestMapping(value = "/comment/{userId}", method ={RequestMethod.DELETE}, produces = "application/json")
    public void deleteAllCommentByUser(@PathParam("userId") @NotNull String userId){

    }


    @RequestMapping(value = "/comment/{blogId}", method ={RequestMethod.DELETE}, produces = "application/json")
    public void deleteAllCommentByBlog(@PathParam("blogId") @NotNull String blogId){

    }

    @RequestMapping(value = "/user/{userId}/comment/{commentId}", method ={RequestMethod.DELETE}, produces = "application/json")
    public void deleteCommentByUser(@PathParam("userId") @NotNull String userId, @PathParam("commentId") @NotNull String commentId){

    }

    @RequestMapping(value = "/comment/{userId}", method ={RequestMethod.GET}, produces = "application/json")
    public CommentRes getAllCommentByUser(@PathParam("userId") @NotNull String userId){
    return null;
    }

    @RequestMapping(value = "/comment/{blogId}", method ={RequestMethod.GET}, produces = "application/json")
    public CommentRes getAllCommentByBlog(@PathParam("blogId") @NotNull String blogId){
     return null;
    }

}
