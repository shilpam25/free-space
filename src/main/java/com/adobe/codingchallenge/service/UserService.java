package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.Blog;
import com.adobe.codingchallenge.model.Comment;
import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.model.UserRes;

import java.util.List;

public interface UserService {

    void registerUser(UserReq user);
    UserRes login(UserReq user);




}
