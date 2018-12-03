package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.model.BlogRes;
import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.model.UserRes;
import com.adobe.codingchallenge.service.BlogService;
import com.adobe.codingchallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller

public class UserApi {

    @Autowired
    UserService userService;

    @Autowired
    BlogService blogService;

    @RequestMapping("/")

    public String index(Model model) {
        List<BlogRes> blogRes= blogService.getBlogs();
        model.addAttribute("latest10blogs", blogRes);
        return "index";
    }

    @RequestMapping(value = "/user/register", method ={RequestMethod.POST}, produces = "application/json")
    public String registerUser(@Valid @RequestBody UserReq user, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "user/login";
        }
        if(userService.registerUser(user) !=null)
            return "redirect:/";
        return "user/register";
    }

    @RequestMapping("/user/login")
    public String login(UserReq user, Model model) {
        model.addAttribute("user", user);
        return "user/login";
    }

    @RequestMapping(value = "/user/login", method =RequestMethod.POST, produces = "application/json")
    public String loginUser(@Valid @RequestBody UserReq user, BindingResult bindingResult, Model model){
        model.addAttribute("user", user);
        if (bindingResult.hasErrors()) {
            return "user/login";
        }
         if(userService.authenticate(user))
         return "redirect:/";
         return "user/login";
    }


    @RequestMapping(value = "/authenticate", method ={RequestMethod.GET}, produces = "application/json")
    public Boolean authenticate(@Valid @RequestBody UserReq user){
        return userService.authenticate(user);

    }

}
