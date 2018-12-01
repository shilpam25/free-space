package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.Blog;
import com.adobe.codingchallenge.model.Comment;
import com.adobe.codingchallenge.model.User;

import java.util.List;

public interface UserService {

    void registerUser(User user);
    void login(User user);




}
