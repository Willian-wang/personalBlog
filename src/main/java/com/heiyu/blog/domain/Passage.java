package com.heiyu.blog.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Date;

/**
 * @author Jayfeather
 * @version 1.0.0
 * @date 2018/12/15
 */
public class Passage {

    private int id;
    private String text;
    private String title;
    private String author;
    private int nodeId;
    private Date updateTime;
    private Date creatTime;
    private boolean isRemove;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
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
        sb.append(",\"text\":\"")
                .append(text).append('\"');
        sb.append(",\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"author\":\"")
                .append(author).append('\"');
        sb.append(",\"nodeId\":")
                .append(nodeId);
        sb.append(",\"updateTime\":\"")
                .append(updateTime).append('\"');
        sb.append(",\"creatTime\":\"")
                .append(creatTime).append('\"');
        sb.append(",\"isRemove\":")
                .append(isRemove);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {return true;}

        if (o == null || getClass() != o.getClass()) {return false;}

        Passage passage = (Passage) o;

        return new EqualsBuilder()
                .append(id, passage.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }
}
