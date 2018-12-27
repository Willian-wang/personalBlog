package com.heiyu.blog.controller;


import com.heiyu.blog.domain.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserController {

    @RequestMapping(value = "/passagelist",method = GET)
    public String getPassageList(@RequestBody int page,String _class){
        return  service.getPassageList(page,_class);
    }

    @RequestMapping(value ="/passage/{id}/text",method = GET )
    public String getPassage(@PathVariable("id") Integer id){
        return service.getPassage();
    }

    @RequestMapping(value ="/passage/{id}/comment",method = GET)
    public String getComment(@PathVariable("id") Integer id){
        return service.getComment();
    }
    @RequestMapping(value = "/passage/{id}/comment",method = POST)
    public String postComment(@PathVariable("id") Integer id, Comment comment){
        return ;
    }
}
