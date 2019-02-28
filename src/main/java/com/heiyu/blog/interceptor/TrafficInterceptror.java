package com.heiyu.blog.interceptor;

import com.heiyu.blog.domain.Log;
import com.heiyu.blog.domain.User;
import com.heiyu.blog.repository.LogRepository;
import com.heiyu.blog.repository.PublicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @ClassName TrafficInterceptror
 * @Description TODO
 * @Author Jayfeather
 * @Date 2019/2/27 10:08
 * @Version 1.0
 **/

public class TrafficInterceptror implements HandlerInterceptor {

    @Autowired
    PublicRepository publicRepository;

    @Autowired
    LogRepository logRepository;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Log log = new Log();
        User user =(User)request.getSession().getAttribute("user");
        log.setId(publicRepository.getMaxID("sys_log","id"));
        log.setIp(request.getRemoteAddr());
        log.setOperate(request.getMethod());
        log.setUrl(request.getRequestURI());
        if(user !=null){
            log.setUserName(user.getUsername());}
        log.setGmtCreatTime(new Date());
        log.setGmtUpdateTime(new Date());
        logRepository.writeLog(log);
    }
}
