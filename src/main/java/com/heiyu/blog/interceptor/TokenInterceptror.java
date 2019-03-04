package com.heiyu.blog.interceptor;

import com.heiyu.blog.domain.User;
import com.heiyu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jayfeather
 * @date 2019/01/12
 * @version 1.0.0
 */


public class TokenInterceptror implements HandlerInterceptor {
    @Autowired
    UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user);
        if(user != null && userService.isLoginMatch(user)){
            return true;}
        else {
            response.setStatus(403);
            return false;}
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

}