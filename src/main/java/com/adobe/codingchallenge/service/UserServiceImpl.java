package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.model.UserDetails;
import com.adobe.codingchallenge.repository.user.UserRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepositoryDao userRepositoryDao;

    @Override
    public UserDetails registerUser(UserReq user) {
        if (userRepositoryDao.findUser(user) != null) {
            throw new IllegalArgumentException("User is already registered");
        }
        UserDetails UserDetails= userRepositoryDao.createUser(user);
        return UserDetails;
    }

    @Override
    public UserDetails getUserDetails(UserReq user) {
        UserDetails UserDetails;

        UserDetails = userRepositoryDao.findUser(user);
        if (UserDetails == null)
            throw new NoSuchElementException("User not found");
        return UserDetails;

    }

    @Override
    public UserDetails getUserDetails(long userId) {
        UserDetails UserDetails;

        UserDetails = userRepositoryDao.getUserDetails(userId);
        if (UserDetails == null)
            throw new NoSuchElementException("User not found");
        return UserDetails;

    }

    @Override
    public Boolean checkUserExists(UserReq user){
        UserDetails UserDetails;
        UserDetails = userRepositoryDao.findUser(user);
        if (UserDetails == null)
            return false;
        return true;
    }


}
