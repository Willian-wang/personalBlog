package com.heiyu.blog.controller;

import com.heiyu.blog.domain.Passage;
import com.heiyu.blog.service.PassageService;
import com.sun.org.apache.bcel.internal.generic.PUSH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import com.heiyu.blog.controller.PublicController;

import static com.heiyu.blog.controller.PublicController.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;


/**
 * @ClassName PassageController
 * @Description TODO
 * @Author Jayfeather
 * @Date 2019/2/1 23:39
 * @Version 1.0
 **/

@RestController
public class PassageController {

    @Autowired
    PassageService passageService;

    @RequestMapping(value = "/admin/passage/",method = POST)
    public String writePassage(@RequestBody Passage passage, HttpServletResponse response){
        Boolean flag =  passageService.wirtePassage(passage);
        setStatuCode(flag,response);
        return null;
    }

    @RequestMapping(value = "/passage/{id}",method = GET)
    public String readPassage(@PathVariable("id") int id,HttpServletResponse response){
        String json = passageService.readPassage(id);
        setStatuCode(json,response);
        return json;
    }


    @RequestMapping(value = "/passagelist/{pageNum}/{pageSize}",method = GET)
    public String readPassageList(@PathVariable("pageNum") int pageNum , @PathVariable("pageSize") int pageSize,HttpServletResponse response){
        String json =  passageService.readPassageList(pageNum,pageSize);
        setStatuCode(json,response);
        return json;
    }

    @RequestMapping(value = "/admin/passage/{id}",method = DELETE)
    public String deletPassage(@PathVariable("id") int id,HttpServletResponse response){
        boolean flag = passageService.deletPassageTest(new Passage(id));
        setStatuCode(flag,response);
        return null;
    }

    @RequestMapping(value = "/admin/passage/{id}",method = PUT)
    public String updatePassage(@PathVariable("id") int id,@RequestBody Passage passage , HttpServletResponse response){
        boolean flag = passageService.updatePassage(passage);
        setStatuCode(flag,response);
        return null;
    }


}
