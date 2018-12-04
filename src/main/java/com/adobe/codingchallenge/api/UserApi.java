package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.model.BlogRes;
import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.model.UserRes;
import com.adobe.codingchallenge.service.BlogService;
import com.adobe.codingchallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public String init(Model model) {
        List<BlogRes> blogRes= blogService.getBlogs();
        model.addAttribute("latest10blogs", blogRes);
        return "index";
    }

    @ModelAttribute(value = "user")
    public UserReq initUser()
    {
        return new UserReq();
    }

    @RequestMapping(value = "/register", method ={RequestMethod.GET}, produces = "application/json")
    public String registerUser(Model model){
        model.addAttribute("user", new UserReq());
        return "user/register";
    }
    // POST method to register user
    @RequestMapping(value = "/register", method ={RequestMethod.POST}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = "application/json")
    public String registerUser(@Valid UserReq user,  BindingResult bindingResult, Model model){
        model.addAttribute("user", new UserReq());
        if (bindingResult.hasErrors()) {
            return "user/login";
        }
        if(userService.registerUser(user) !=null)
            return "redirect:/";
        return "user/register";
    }

    //POST method to login user
    @RequestMapping(value = "/login", method =RequestMethod.GET, produces = "application/json")
    public String loginUser(Model model){
        model.addAttribute("user", new UserReq());
        return "user/login";
    }


    //POST method to login user
    @RequestMapping(value = "/login", method =RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = "application/json")
    public String loginUser(@Valid UserReq user, BindingResult bindingResult, Model model){
        //model.addAttribute("user", new UserReq());
        if (bindingResult.hasErrors()) {
            return "user/login";
        }
         if(userService.checkUserExists(user))
         return "redirect:/";
         return "user/login";
    }


    //GET method to fetch user details
    @RequestMapping(value = "/user-details", method =RequestMethod.GET, produces = "application/json")
    public UserRes userDetails(@RequestParam int userId){
        UserRes userRes;
        userRes = userService.getUserDetails(userId);
        return userRes;
    }

//TODO implement authentication for logged in user
    @RequestMapping(value = "/authenticate", method ={RequestMethod.GET}, produces = "application/json")
    public Boolean authenticate(){
        return true;

    }
//TODO implement logout method
    @RequestMapping(value = "/logout", method =RequestMethod.GET, produces = "application/json")
    public void logout(@RequestParam int userId){

    }


}
