package com.heiyu.blog.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.validation.constraints.Email;
import java.util.Date;

/**
 * @author Jayfeather
 * @version 1.0.0
 * @date 2018/12/15
 */

public class User  {

    private int id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String lastIp;
    private Date lastLoginTime;
    private Date creatTime;
    private Date updateTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRemove() {
        return isRemove;
    }

    public void setRemove(boolean remove) {
        isRemove = remove;
    }

    private boolean isRemove;

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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updatTime) {
        this.updateTime = updatTime;
    }

    public User(){}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"phoneNumber\":\"")
                .append(phoneNumber).append('\"');
        sb.append(",\"lastIp\":\"")
                .append(lastIp).append('\"');
        sb.append(",\"lastLoginTime\":\"")
                .append(lastLoginTime).append('\"');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}

        if (!(o instanceof User)) {return false;}

        User user = (User) o;

        return new EqualsBuilder()
                .append(getUsername(), user.getUsername())
                .append(getPassword(), user.getPassword())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getUsername())
                .append(getPassword())
                .toHashCode();
    }
}
