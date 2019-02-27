package com.heiyu.blog.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginInterceptror
 * @Description TODO
 * @Author Jayfeather
 * @Date 2019/2/27 10:08
 * @Version 1.0
 **/
public class LoginInterceptror implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        request.getSession().setAttribute();
    }
}
