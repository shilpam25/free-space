package com.adobe.codingchallenge.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="comment")
public class Comment {
    public Comment(){

    }
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="commentId")
    private int commentId;

    @Column(name="blogId")
    private int blogId;

    @Column(name="userId")
    private int userId;

    @Column(name="comment_desc")
    private String commentDesc;

    @Column(name="cretDt")
    private Date cretDt;

    @Column(name="updtDt")
    private Date updtDt;

    @Column(name="inactvDt")
    private Date inactvDt;


    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc;
    }

    public Date getCretDt() {
        return cretDt;
    }

    public void setCretDt(Date cretDt) {
        this.cretDt = cretDt;
    }

    public Date getUpdtDt() {
        return updtDt;
    }

    public void setUpdtDt(Date updtDt) {
        this.updtDt = updtDt;
    }

    public Date getInactvDt() {
        return inactvDt;
    }

    public void setInactvDt(Date inactvDt) {
        this.inactvDt = inactvDt;
    }

}
