package com.adobe.codingchallenge.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="blog")
public class Blog {

    public Blog(){

    }
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="blogId")
    private int blogId;

    @Column(name="userId")
    private long userId;

    @Column(name="title")
    private String title;



    @Column(name="description")
    private String desc;

    @Column(name="cretDt")
    private Date cretDt;

    @Column(name="updtDt")
    private Date updtDt;

    @Column(name="inactvDt")
    private Date inactvDt;

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
