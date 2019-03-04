package com.heiyu.blog.controller;

import com.heiyu.blog.domain.User;
import com.heiyu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.client.HttpClientErrorException.*;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponseWrapper;

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

    @Autowired
    private HttpServletResponse response;

    private static String SUCCESS = "{\"login\":1}";
    private static String FAILED  = "{\"login\":0}";


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
            return SUCCESS;
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
            return SUCCESS;
        } else {
            return "{\"login\":0}";
        }
    }
    @RequestMapping(value = "/logout" , method = GET)
    @ResponseBody
    public String logout(){
        request.getSession().removeAttribute("user");
        return SUCCESS;
    }


    @RequestMapping(value = "/admin/user/{userName}" , method = GET)
    @ResponseBody
    public String readUser(@PathVariable("userName") String userName ,HttpServletResponse response ){
        User user = new User();
        user.setUsername(userName);
        if(!isUsernameMatch(user)){
            return null;
        }
        user = userService.readUser(user);
        return user.toString();
    }


    public String getIP(){
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

    public boolean isUsernameMatch(User user){
        User userInSession = (User) request.getSession().getAttribute("user");
        if(user.getUsername().equals(userInSession.getUsername())){
            return true;
        }else {
            response.setStatus(403);
            return  false;
        }
    }
}


