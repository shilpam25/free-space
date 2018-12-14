package com.adobe.codingchallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogReq implements Serializable {

    @NotBlank(message = "Title should not be empty")
    private String title;

    @NotBlank(message = "Description should not be empty")
    private String desc;

    @NotNull(message = "Description should not be empty")
    private long userId;

    private int blogId;

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BlogReq{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", userId=" + userId +
                ", blogId=" + blogId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlogReq)) return false;
        BlogReq blogReq = (BlogReq) o;
        return getUserId() == blogReq.getUserId() &&
                getBlogId() == blogReq.getBlogId() &&
                Objects.equals(getTitle(), blogReq.getTitle()) &&
                Objects.equals(getDesc(), blogReq.getDesc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDesc(), getUserId(), getBlogId());
    }
}
