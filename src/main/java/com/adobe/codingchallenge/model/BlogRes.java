package com.adobe.codingchallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogRes implements Serializable {

    private int blogId;
    private String title;
    private String desc;
    private Date cretDt;
    private List<CommentDetails> commentResList;


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

    public List<CommentDetails> getCommentResList() {
        return commentResList;
    }

    public void setCommentResList(List<CommentDetails> commentResList) {
        this.commentResList = commentResList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlogRes)) return false;
        BlogRes blogRes = (BlogRes) o;
        return getBlogId() == blogRes.getBlogId() &&
                Objects.equals(getTitle(), blogRes.getTitle()) &&
                Objects.equals(getDesc(), blogRes.getDesc()) &&
                Objects.equals(getCretDt(), blogRes.getCretDt()) &&
                Objects.equals(getCommentResList(), blogRes.getCommentResList()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBlogId(), getTitle(), getDesc(), getCretDt(), getCommentResList());
    }

    @Override
    public String toString() {
        return "BlogRes{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", cretDt=" + cretDt +
                ", commentResList=" + commentResList +
                '}';
    }
}
