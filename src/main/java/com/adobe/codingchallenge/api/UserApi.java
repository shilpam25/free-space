package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController

public class UserApi {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping(value = "/register", method ={RequestMethod.POST}, produces = "application/json")
    public void registerUser(@Valid @RequestBody UserReq user){
        userService.registerUser(user);
        System.out.println("This User" + user);

    }

    @RequestMapping(value = "/login", method ={RequestMethod.POST}, produces = "application/json")
    public void login(@Valid @RequestBody UserReq user){
        System.out.println("This User" + user);

    }

}
