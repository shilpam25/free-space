package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.model.BlogRes;
import com.adobe.codingchallenge.model.GetUserRes;
import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.model.UserDetails;
import com.adobe.codingchallenge.service.BlogService;
import com.adobe.codingchallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class UserApi {

    @Autowired
    UserService userService;

    @Autowired
    BlogService blogService;

    @RequestMapping("/")
    public void init() {
        List<BlogRes> blogRes = blogService.getBlogs();
        //model.addAttribute("blogList", blogRes);

        //return "index";
    }

//    @ModelAttribute(value = "user")
//    public UserReq initUser() {
//        return new UserReq();
//    }

//    @RequestMapping(value = "/register", method = {RequestMethod.GET}, produces = "application/json")
//    public String registerUser(Model model) {
//        model.addAttribute("user", new UserReq());
//        //return "user/register";
//    }

    // POST method to register user
    @RequestMapping(value = "/register", method = {RequestMethod.POST}, consumes = {"application/json"}, produces = {"application/json"})
    public UserDetails registerUser(@RequestBody @Valid  UserReq user) {
//        model.addAttribute("user", new UserReq());
//        if (bindingResult.hasErrors()) {
//            //return "user/register";
//            return null;
//        }
        UserDetails userDetails= userService.registerUser(user);
        if (userDetails != null)
            return userDetails;
        return null;
//            return "redirect:/";
//        return "user/register";
    }

//    //POST method to login user
//    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
//    public String loginUser(Model model) {
//        model.addAttribute("user", new UserReq());
//        model.addAttribute("blogList", new ArrayList<BlogRes>());
//        return "user/login";
//    }


    //POST method to login user
    @RequestMapping(value = "/login", method = {RequestMethod.POST}, consumes = {"application/json"}, produces = "application/json")
    public GetUserRes loginUser(@Valid UserReq user) {
        GetUserRes getUserRes = new GetUserRes();
//        model.addAttribute("user", new UserReq());
//        if (bindingResult.hasErrors()) {
//            return "user/login";
//        }
        if (userService.checkUserExists(user)) {
            UserDetails userDetails = userService.getUserDetails(user);
            List<BlogRes> userBlogList = blogService.getAllBlogByUser(userDetails.getUserId());
//            model.addAttribute("blogList", userBlogList);
//            return "redirect:/";
            getUserRes.setUserDetails(userDetails);
            getUserRes.setBlogList(userBlogList);
            return getUserRes;
        }
        return null;
       // return "user/login";
    }


    //GET method to fetch user details
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
    public GetUserRes userDetails(@PathVariable @NotNull String userId) {
        GetUserRes getUserRes = new GetUserRes();
        UserDetails userDetails;
        userDetails = userService.getUserDetails((Long.parseLong(userId)));
        List<BlogRes> userBlogList = blogService.getAllBlogByUser(userDetails.getUserId());
        getUserRes.setBlogList(userBlogList);
        getUserRes.setUserDetails(userDetails);
        return getUserRes;
        //model.addAttribute("UserDetails", UserDetails);
        //return "redirect:/";
    }

    //TODO implement authentication for logged in user
    @RequestMapping(value = "/authenticate", method = {RequestMethod.GET}, produces = "application/json")
    public Boolean authenticate() {
        return true;

    }

    //TODO implement logout method
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json")
    public void logout(@RequestParam int userId) {

    }


}
