package com.heiyu.blog.controller;

import com.heiyu.blog.domain.User;
import com.heiyu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author Jayfeather
 * @version 1.0.0
 * @date 2018/12/15
 */

@EnableAutoConfiguration
@RestController
@RequestMapping
@CrossOrigin
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;


//    @RequestMapping(value = "/login",method = GET)
//    public ModelAndView login(){
//        return new ModelAndView("login");
//    }

    @RequestMapping(value = "/login",method = POST)
    @ResponseBody
    public String loginPost(@RequestBody User user) {
        System.out.println(user);
        user.setLastIp(getIP());
        if (userService.isLoginMatch(user)) {
            request.getSession().setAttribute("user",user);
            return "{\"login\":1}";
        } else {
            return "{\"login\":0}";
        }
    }

    @RequestMapping(value = "/resign",method = GET)
    public ModelAndView resign(){ return new ModelAndView("resign");}

    @RequestMapping(value = "/resign",method = POST)
    @ResponseBody
    public String resignPost(@RequestBody User user){
        user.setLastIp(getIP());

        if (userService.resignUser(user)) {
            request.getSession().setAttribute("user",user);
            return "{\"login\":1}";
        } else {
            return "{\"login\":0}";
        }
    }




    public String getIP(){
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
}


