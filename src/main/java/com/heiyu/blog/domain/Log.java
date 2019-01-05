package com.heiyu.blog.domain;

public class Log {

    private User user;

    private String operate;

    private String url;

    private String ip;

    private String gmtCreatTime;

    private String gmtUpdateTime;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getGmtCreatTime() {
        return gmtCreatTime;
    }

    public void setGmtCreatTime(String gmtCreatTime) {
        this.gmtCreatTime = gmtCreatTime;
    }

    public String getGmtUpdateTime() {
        return gmtUpdateTime;
    }

    public void setGmtUpdateTime(String gmtUpdateTime) {
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
