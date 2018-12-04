package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.Blog;
import com.adobe.codingchallenge.model.Comment;
import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.model.UserRes;

import java.util.List;

public interface UserService {

    UserRes registerUser(UserReq user);
    UserRes getUserDetails(int user);
    Boolean checkUserExists(UserReq user);




}
