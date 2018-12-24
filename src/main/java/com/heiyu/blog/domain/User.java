package com.heiyu.blog.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.validation.constraints.Email;
import java.util.Date;

public class User extends LoginUser {

    private String email;
    private String phoneNumber;
    private String lastIp;
    private Date lastLoginTime;
    private Date creatTime;
    private Date updatTime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdatTime() {
        return updatTime;
    }

    public void setUpdatTime(Date updatTime) {
        this.updatTime = updatTime;
    }

    public User(){}

    User(String username, String password) {
        super(username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='"+getUsername()+'\''+
                ", password='"+getPassword()+'\''+
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", creatTime=" + creatTime +
                ", updatTime=" + updatTime +
                '}';
    }

/**TODO 重写hash和equal方法
 *
 */


}
