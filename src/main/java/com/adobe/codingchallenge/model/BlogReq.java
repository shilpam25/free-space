package com.adobe.codingchallenge.model;

import org.hibernate.validator.constraints.NotBlank;

public class BlogReq {
    private int blogId;


    @NotBlank(message = "Title should not be empty")
    private String title;

    @NotBlank(message = "Description should not be empty")
    private String desc;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}