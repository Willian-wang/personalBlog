package com.heiyu.blog.domain;

import javax.xml.soap.Text;
import java.util.Date;
/**
 * @author Jayfeather
 * @version 1.0.0
 * @date 2018/12/15
 */
public class Comment {

    private int id;

    private Guest guest;

    private String text;

    private int articleId;

    private int replayId;

    private Date updateTime;

    private Date creatTime;

    private boolean isRemove;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getReplayId() {
        return replayId;
    }

    public void setReplayId(int replayId) {
        this.replayId = replayId;
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

    public boolean isRemove() {
        return isRemove;
    }

    public void setRemove(boolean remove) {
        isRemove = remove;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"guest\":")
                .append(guest);
        sb.append(",\"text\":\"")
                .append(text).append('\"');
        sb.append(",\"articleId\":")
                .append(articleId);
        sb.append(",\"replayId\":")
                .append(replayId);
        sb.append(",\"updateTime\":\"")
                .append(updateTime).append('\"');
        sb.append(",\"creatTime\":\"")
                .append(creatTime).append('\"');
        sb.append(",\"isRemove\":")
                .append(isRemove);
        sb.append('}');
        return sb.toString();
    }
}