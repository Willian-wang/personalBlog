package com.heiyu.blog.service;

import com.heiyu.blog.domain.Comment;
import com.heiyu.blog.repository.CommentRepository;
import com.heiyu.blog.repository.PublicRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName CommentService
 * @Description TODO
 * @Author Jayfeather
 * @Date 2019/2/1 0:29
 * @Version 1.0
 **/
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PublicRepository publicRepository;

    public String readComment(int passageId){
        String commentStr="";
        List comments =  commentRepository.readComment(passageId);
        for(Object comment:comments){
            comment=(Comment)comment;
            commentStr+=comment.toString();
        }
        return commentStr;
    }

    public boolean writeComment(Comment comment){
        Date date = new Date();
        comment.setId(publicRepository.getMaxID("article_comment","comment_id")+1);
        comment.setUpdateTime(date);
        comment.setCreatTime(date);
        comment.setRemove(false);
        return commentRepository.writeComment(comment);
    }

    public boolean updateComment(Comment comment){
        comment.setUpdateTime(new Date());
        return commentRepository.updateComment(comment);
    }

    public boolean deletComment(Comment comment){
        comment.setRemove(true);
        comment.setUpdateTime(new Date());
        return commentRepository.deletComment(comment);
    }

}
