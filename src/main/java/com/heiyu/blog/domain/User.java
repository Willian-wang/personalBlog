package com.heiyu.blog.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.validation.constraints.Email;
import java.util.Date;

public class User  {

    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String lastIp;
    private Date lastLoginTime;
    private Date creatTime;
    private Date updatTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


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

    @Override
    public String toString() {
        return "User{" +
                "userName='"+username+'\''+
                ", password='"+password+'\''+
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", creatTime=" + creatTime +
                ", updatTime=" + updatTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new org.apache.commons.lang.builder.EqualsBuilder()
                .append(username, user.username)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang.builder.HashCodeBuilder(17, 37)
                .append(username)
                .toHashCode();
    }

}
