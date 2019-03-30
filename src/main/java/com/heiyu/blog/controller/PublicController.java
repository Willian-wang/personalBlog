package com.heiyu.blog.controller;

import com.heiyu.blog.repository.PublicRepository;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName PublicController
 * @Description TODO
 * @Author Jayfeather
 * @Date 2019/2/3 17:30
 * @Version 1.0
 **/
public abstract class PublicController {

    static String SUCCESS = "{\"status\":\"0001\"}";

    static String NOTFOUND = "{\"status\":\"0004\"}";

    static String SERVERERROW = "{\"status\":\"0005\"}";

    static String LOGINSUCCESS = "{\"login\":1}";

    static String LOGINFAILED  = "{\"login\":0}";

    static void setStatuCode(String json , HttpServletResponse response) {
        if(json==""){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }else if(json==null){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }else {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    static void setStatuCode(boolean flag, HttpServletResponse response){
        if(flag){
            response.setStatus(HttpServletResponse.SC_OK);
        }else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
