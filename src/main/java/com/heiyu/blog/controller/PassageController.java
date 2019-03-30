package com.heiyu.blog.controller;

import com.heiyu.blog.domain.Passage;
import com.heiyu.blog.service.PassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import com.heiyu.blog.controller.PublicController;

import static com.heiyu.blog.controller.PublicController.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;



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

    @RequestMapping(value = "/admin/passage/{id}",method = POST)
    public String writePassage(@PathVariable("id") int id, @RequestBody Passage passage, HttpServletResponse response){
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


}
