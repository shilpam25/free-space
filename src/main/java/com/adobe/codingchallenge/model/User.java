package com.adobe.codingchallenge.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name ="user")

public class User implements Serializable {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="userId")
    private long userId;
    @Column(name="userEmail")
    private String userEmail;
    @Column(name="password")
    private String password;
    @Column(name="cretDt")
    private Date cretDt;
    @Column(name="inactvDt")
    private Date inactvDt;
    public User(){

}


    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCretDt() {
        return cretDt;
    }

    public void setCretDt(Date cretDt) {
        this.cretDt = cretDt;
    }

    public Date getInactvDt() {
        return inactvDt;
    }

    public void setInactvDt(Date inactvDt) {
        this.inactvDt = inactvDt;
    }


    public long getUserId() {
        return userId;
    }
}
