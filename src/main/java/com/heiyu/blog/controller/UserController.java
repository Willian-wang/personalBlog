package com.heiyu.blog.controller;


import com.heiyu.blog.domain.Comment;
import com.heiyu.blog.domain.Passage;
import com.heiyu.blog.service.CommentService;
import com.heiyu.blog.service.PassageService;
import com.heiyu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;


/**
 * @author Jayfeather
 * @version 1.0.0
 * @date 2018/12/15
 */


@RestController
public class UserController {
    
    @Autowired
    private PassageService passageService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/passage",method = POST)
    public String writePassage(@RequestBody Passage passage){
        if(passageService.wirtePassage(passage)) {
            return "{\"writePassage\":1}";
        }else{
            return "{\"writePassage\":0}";
        }
    }

    @RequestMapping(value = "/passagelist",method = GET)
    public String readPassageList(@RequestBody int page,String list){
        return  passageService.readPassageList();
    }

    @RequestMappieng(value ="/passage/{id}/text",method = GET )
    public String getPassage(@PathVariable("id") Integer id){
        return passageService.readPassage(id);
    }

    @RequestMapping(value ="/passage/{id}/comment",method = GET)
    public String readComment(@PathVariable("id") Integer id){
        return passageService.readComment(id);
    }

    @RequestMapping(value = "/passage/{id}/comment",method = POST)
    public String postComment(@PathVariable("id") Integer id,@RequestBody Comment comment){
        return passageService.postComment(comment);
   }

   @RequestMapping(value = "/passage/{}/comment",method = POST)
    public String
}
