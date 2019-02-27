package com.heiyu.blog.config;

import com.heiyu.blog.interceptor.LoginInterceptror;
import com.heiyu.blog.interceptor.TokenInterceptror;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName
 * @Description TODO
 * @Author Jayfeather
 * @Date 2019/2/27 9:10
 * @Version 1.0
 **/

@Configurable
public class InterceptrorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptror()).addPathPatterns("/admin/**").excludePathPatterns("/login");
        registry.addInterceptor(new LoginInterceptror()).addPathPatterns("/login");
    }
}
