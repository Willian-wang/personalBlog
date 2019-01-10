package com.heiyu.blog.controller;


import com.heiyu.blog.domain.Comment;
import com.heiyu.blog.domain.Passage;
import com.heiyu.blog.service.PassageService;
import com.heiyu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserController {
    
    @Autowired
    private PassageService passageService;

    @RequestMapping(value = "/passage",method = POST)
    public String writePassage(@RequestBody Passage passage){
        if(passageService.wirtePassage(passage)) {
            return "{\"writePassage\":1}";
        }else{
            return "{\"writePassage\":0}";
        }
    }

    @RequestMapping(value = "/passagelist",method = GET)
    public String getPassageList(@RequestBody int page,String _class){
        return  passageService.getPassageList(page,_class);
    }

    @RequestMapping(value ="/passage/{id}/text",method = GET )
    public String getPassage(@PathVariable("id") Integer id){
        return passageService.getPassage();
    }

    @RequestMapping(value ="/passage/{id}/comment",method = GET)
    public String getComment(@PathVariable("id") Integer id){
        return passageService.getComment();
    }

    @RequestMapping(value = "/passage/{id}/comment",method = POST)
    public String postComment(@PathVariable("id") Integer id,@RequestBody Comment comment){
        return passageService.postComment(comment);
    }
}
