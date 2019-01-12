package com.heiyu.blog.service;

import com.heiyu.blog.domain.Comment;
import com.heiyu.blog.domain.Passage;
import com.heiyu.blog.repository.PassageRepository;
import com.heiyu.blog.repository.PublicRepository;
import com.heiyu.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Jayfeater
 * @version 1.0.0
 * @date 2019/1/7
 */

@Service
public class PassageService {

    @Autowired
    private PassageRepository passageRepository;

    @Autowired
    private PublicRepository publicRepository;

    @Autowired
    private Passage passage;

    Date date = new Date();
    
    public Boolean wirtePassage() {

        passage.setCreatTime(date);
        passage.setRemove(false);
        passage.setUpdateTime(date);
        passage.setId(publicRepository.getMaxID("article_inf","article_id"));
        if(passageRepository.writePassage(passage)){
            return true;
        }else{
            return false;
        }
    }

    public String updatePassage(Passage passage){

    }

    public String getPassageList(int page, String aClass) {
    }


    public String getPassage() {
    }

    public String getComment() {
    }

    public String postComment(Comment comment) {
    }
}
