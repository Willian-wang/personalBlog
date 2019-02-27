package com.heiyu.blog.config;


import org.omg.PortableInterceptor.Interceptor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Jayfeather
 * @version 1.0.0
 * @date 2018/01/12
 */


@EnableAutoConfiguration
@EnableWebMvc
public class WebConfig extends WebMvcAutoConfiguration {

}
