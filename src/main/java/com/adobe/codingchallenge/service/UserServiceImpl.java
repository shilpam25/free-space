package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.repository.user.UserRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepositoryDao userRepositoryDao;

    @Override
    public void registerUser(UserReq user) {
        if (userRepositoryDao.findUser(user)) {
            System.out.println("Your are already registered");
            return; }
        userRepositoryDao.createUser(user);
        System.out.println("Your registration to Free space is successful");
        System.out.println("Welcome:" + user.getUserId());
    }

    @Override
    public void login(UserReq user) {
        if(!userRepositoryDao.findUser(user))
            return;
        System.out.println("Login Successful");

    }




}
