package com.heiyu.blog.controller;


import com.heiyu.blog.domain.Guest;
import com.heiyu.blog.domain.User;
import com.heiyu.blog.service.CommentService;
import com.heiyu.blog.service.PassageService;
import com.heiyu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static com.heiyu.blog.controller.PublicController.*;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.*;


/**
 * @author Jayfeather
 * @version 1.0.0
 * @date 2018/12/15
 */


@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private HttpServletResponse response;

    @RequestMapping(value = "/admin/user/{id}" ,method = PUT)
    public String updateUserInf(@PathVariable("id") int id,@RequestBody User user){
        boolean flag = userService.updateUserInf(user);
        setStatuCode(flag,response);
        return null;
    }

    @RequestMapping(value = "/admin/user/{id}" , method = PUT)
    public String updateUserPassword(@PathVariable("id") int id,@RequestBody User user){
       boolean flag;
       if(user.getPassword()==null){
           flag =  userService.updateUserPassword(user);
       }else {
           flag = userService.updateUserPassword(user);
       }
       setStatuCode(flag,response);
       return null;
    }

    @RequestMapping(value = "/admin/userlist/{pagenum}/{pagesize}",method = GET )
    public String readUserList(@PathVariable("pagenum") int pageNum,@PathVariable("pagesize") int pageSize){
        String json = userService.readUserList(pageNum,pageSize);
        setStatuCode(json,response);
        return json;
    }

    @RequestMapping(value = "/admin/user/{id}",method = DELETE)
    public String deletUser(@PathVariable("id") int id){
        boolean flag = userService.deletUser(new User(id));
        setStatuCode(flag,response);
        return null;
    }

    @RequestMapping(value = "/admin/guest/",method = GET)
    public String writeGuest(@RequestBody Guest guest){
        int count = userService.writeGuest(guest);
        if(count==0){
            return LOGINSUCCESS;
        }else {
            return LOGINFAILED;
        }
    }

    @RequestMapping(value = "/admin/guest/{pageNum}/{pageSize}",method = GET)
    public String readGuestList(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
        String json = userService.readGuestList(pageNum,pageSize);
        setStatuCode(json,response);
        return json;
    }


}
