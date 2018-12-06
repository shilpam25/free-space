package com.adobe.codingchallenge.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BlogRes implements Serializable {

    private int blogId;
    private String title;
    private String desc;
    private Date cretDt;

    private List<CommentRes> commentResList;
    private UserRes userRes;


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

    public Date getCretDt() {
        return cretDt;
    }

    public void setCretDt(Date cretDt) {
        this.cretDt = cretDt;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public List<CommentRes> getCommentResList() {
        return commentResList;
    }

    public void setCommentResList(List<CommentRes> commentResList) {
        this.commentResList = commentResList;
    }

    public UserRes getUserRes() {
        return userRes;
    }

    public void setUserRes(UserRes userRes) {
        this.userRes = userRes;
    }


}
