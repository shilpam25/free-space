package com.adobe.codingchallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentDetails implements Serializable {

    private long commentId;
    private String commentDesc;
//    private Date cretDt;
//    private Date updtDt;
//    private Date inactvDt;


    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc;
    }
//
//    public Date getCretDt() {
//        return cretDt;
//    }
//
//    public void setCretDt(Date cretDt) {
//        this.cretDt = cretDt;
//    }
//
//    public Date getUpdtDt() {
//        return updtDt;
//    }
//
//    public void setUpdtDt(Date updtDt) {
//        this.updtDt = updtDt;
//    }
//
//    public Date getInactvDt() {
//        return inactvDt;
//    }
//
//    public void setInactvDt(Date inactvDt) {
//        this.inactvDt = inactvDt;
//    }
//

}
