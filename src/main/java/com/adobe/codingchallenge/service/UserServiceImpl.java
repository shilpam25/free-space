package com.adobe.codingchallenge.service;

import com.adobe.codingchallenge.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Override
    public void registerUser(User user) {
        if (isAlreadyRegister(user)) {
            System.out.println("Your rare already registered");
            return;
        }
        System.out.println("Your registration to Free space is successful");
        System.out.println("Your Name:" + user.getUserId());
        System.out.println("Your password:" + user.getPwd());
    }

    @Override
    public void login(User user) {
        if(!isValidateUser(user))
            return;
        System.out.println("Login Successful");

    }

    public boolean isValidateUser(User user) {
        return true;
    }

    public boolean isAlreadyRegister(User user) {
        return true;
    }

}
