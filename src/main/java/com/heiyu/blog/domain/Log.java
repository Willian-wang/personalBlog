package com.heiyu.blog.domain;


import java.util.Date;

/**
 * @author Jayfeather
 * @version 1.0.0
 * @date 2018/12/15
 */
public class Log {
    private int id;

    private String userName;

    private String operate;

    private String url;

    private String ip;

    private Date gmtCreatTime;

    private Date gmtUpdateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getGmtCreatTime() {
        return gmtCreatTime;
    }

    public void setGmtCreatTime(Date gmtCreatTime) {
        this.gmtCreatTime = gmtCreatTime;
    }

    public Date getGmtUpdateTime() {
        return gmtUpdateTime;
    }

    public void setGmtUpdateTime(Date gmtUpdateTime) {
        this.gmtUpdateTime = gmtUpdateTime;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
