package com.heiyu.blog.controller;


import com.heiyu.blog.service.CommentService;
import com.heiyu.blog.service.PassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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



//    @RequestMapping(value ="/passage/{id}/comment",method = GET)
//    public String readComment(@PathVariable("id") Integer id){
//        return passageService.readComment(id);
//    }

//    @RequestMapping(value = "/passage/{id}/comment",method = POST)
//    public String postComment(@PathVariable("id") Integer id,@RequestBody Comment comment){
//        return passageService.writeComment(comment);
//   }
//
//   @RequestMapping(value = "/passage/{}/comment",method = POST)
//    public String
}
