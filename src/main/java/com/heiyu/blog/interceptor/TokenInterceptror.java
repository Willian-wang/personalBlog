package com.heiyu.blog.interceptor;

import com.heiyu.blog.domain.User;
import com.heiyu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        String userName = (String) request.getSession().getAttribute("userName");
        String hashCode = (String) request.getSession().getAttribute("hashCode");
        if(userService.isLoginMatch())
            return true;
        else return false
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

}

/*
大概是利用request的方法……
request的各种各样的方法……
 */
