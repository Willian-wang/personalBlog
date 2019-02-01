package com.heiyu.blog.domain;

import java.util.Date;

/**
 * @author Jayfeather
 * @version 1.0.0
 * @date 2018/12/15
 */
public class Guest {

    private int id;

    private String name;

    private String ip;

    private String email;

    private String blog;

    private Date updateTime;

    private Date creatTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"ip\":\"")
                .append(ip).append('\"');
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"blog\":\"")
                .append(blog).append('\"');
        sb.append(",\"updateTime\":\"")
                .append(updateTime).append('\"');
        sb.append(",\"creatTime\":\"")
                .append(creatTime).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
