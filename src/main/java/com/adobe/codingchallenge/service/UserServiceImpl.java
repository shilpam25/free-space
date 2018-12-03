package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.model.UserRes;
import com.adobe.codingchallenge.repository.user.UserRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepositoryDao userRepositoryDao;

    @Override
    public UserRes registerUser(UserReq user) {
        if (userRepositoryDao.findUser(user) != null) {
            throw new IllegalArgumentException("User is already registered");
        }
        UserRes userRes= userRepositoryDao.createUser(user);
        return userRes;
    }

    @Override
    public UserRes getUserDetails(UserReq user) {
        UserRes userRes;
        userRes = userRepositoryDao.findUser(user);
        if (userRes == null)
            throw new NoSuchElementException("User not found");
        return userRes;

    }

    @Override
    public Boolean authenticate(UserReq user){
        UserRes userRes;
        userRes = userRepositoryDao.findUser(user);
        if (userRes == null)
            return false;
        return true;
    }


}
