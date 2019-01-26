package com.heiyu.blog.service;

import com.heiyu.blog.domain.Comment;
import com.heiyu.blog.domain.Passage;
import com.heiyu.blog.repository.PassageRepository;
import com.heiyu.blog.repository.PublicRepository;
import com.heiyu.blog.repository.UserRepository;
import org.omg.CORBA.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static sun.swing.MenuItemLayoutHelper.max;

/**
 * @author Jayfeater
 * @version 1.0.0
 * @date 2019/1/26
 */

@Service
public class PassageService {

    @Autowired
    private PassageRepository passageRepository;

    @Autowired
    private PublicRepository publicRepository;



    Date date = new Date();
    
    public Boolean wirtePassage(Passage passage) {

        passage.setCreatTime(date);
        passage.setRemove(false);
        passage.setUpdateTime(date);
        int id = max(publicRepository.getMaxID("article_inf","article_id"),
                publicRepository.getMaxID("article_text","article_id"))+1;
        passage.setId(id);
        if(passageRepository.writePassage(passage)){
            return true;
        }else{
            return false;
        }
    }
    public boolean deletPassageTest(Passage passage) {
        passage.setRemove(true);
        passage.setUpdateTime(new Date());
        if(passageRepository.deletePassage(passage)){
            return true;
        }else {
            return false;
        }
    }

    public boolean updatePassage(Passage passage){
        passage.setUpdateTime(new Date());
        if(passageRepository.updatePassage(passage)){
            return true;
        }else{
            return false;
        }
    }

    public String getPassageList(int page, int pageSize) {
        List<Passage> passages ;
        passages = passageRepository.getPassageList(page,pageSize);
        Iterator<Passage> iterator = passages.iterator();
        String passageListJson="";
        if(passages != null){
            while (iterator.hasNext()){
                Passage passage =  iterator.next();
                passageListJson+=passage.toString();
            }
            System.out.println(passageListJson);
            return passageListJson;
        }else {
            return null;
        }
    }



//    public String getPassage() {
//    }
//
//    public String getComment() {
//    }
//
//    public String postComment(Comment comment) {
//    }
}
