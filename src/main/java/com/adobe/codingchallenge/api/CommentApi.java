package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.model.CommentDetails;
import com.adobe.codingchallenge.model.CommentReq;
import com.adobe.codingchallenge.model.CommentRes;
import com.adobe.codingchallenge.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class CommentApi {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/user/blog", method ={RequestMethod.POST}, consumes = {"application/json"}, produces = {"application/json"})
    public void postComment(@Valid @RequestBody CommentReq commentReq){
        commentService.postComment(commentReq);
    }

    @RequestMapping(value = "/user/{userId}/comments", method ={RequestMethod.DELETE}, produces = "application/json")
    public void deleteAllCommentByUser(@PathVariable("userId") @NotNull String userId){
        commentService.deleteAllCommentByUser(Long.parseLong(userId));

    }

    @RequestMapping(value = "/blog/{blogId}/comments", method ={RequestMethod.DELETE}, produces = "application/json")
    public @ResponseBody void deleteAllCommentByBlog(@PathVariable("blogId") @NotNull String blogId){
        commentService.deleteAllCommentByBlog(Long.parseLong(blogId));

    }

    @RequestMapping(value = "/user/{userId}/comment/{commentId}", method ={RequestMethod.DELETE}, produces = "application/json")
    public @ResponseBody void deleteCommentByUser(@PathVariable("userId") @NotNull String userId, @PathVariable("commentId") @NotNull String commentId){
        commentService.deleteComment(Long.parseLong(commentId), Long.parseLong(userId));
    }

    @RequestMapping(value = "/user/{userId}/comments", method ={RequestMethod.GET}, produces = "application/json")
    public @ResponseBody
    CommentRes getAllCommentByUser(@PathVariable("userId") @NotNull String userId, Model model)

    {
        CommentRes commentRes = new CommentRes();

        List<CommentDetails> commentDetailsList = commentService.retreiveAllByUser(Long.parseLong(userId));
        //model.addAttribute("userComments", commentResList);
        commentRes.setCommentDetailsList(commentDetailsList);
        return commentRes;
    }

    @RequestMapping(value = "/blog/{blogId}/comments", method ={RequestMethod.GET}, produces = "application/json")
    public @ResponseBody List<CommentDetails> getAllCommentByBlog(@PathVariable("blogId") @NotNull String blogId)
    {
     return commentService.retreiveAllByBlog(Long.parseLong(blogId));
    }


}
