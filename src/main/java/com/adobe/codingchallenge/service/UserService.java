package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.Blog;
import com.adobe.codingchallenge.model.Comment;
import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.model.UserDetails;

import java.util.List;

public interface UserService {

    UserDetails registerUser(UserReq user);
    UserDetails getUserDetails(UserReq user);
    UserDetails getUserDetails(long userId);
    Boolean checkUserExists(UserReq user);




}
