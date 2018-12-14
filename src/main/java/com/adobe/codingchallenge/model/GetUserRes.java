package com.adobe.codingchallenge.model;

import java.util.List;

public class GetUserRes{

private UserDetails userDetails;
private List<BlogRes> blogList;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public List<BlogRes> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<BlogRes> blogList) {
        this.blogList = blogList;
    }
}
