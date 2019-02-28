package com.heiyu.blog.config;

import com.heiyu.blog.interceptor.TrafficInterceptror;
import com.heiyu.blog.interceptor.TokenInterceptror;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName
 * @Description TODO
 * @Author Jayfeather
 * @Date 2019/2/27 9:10
 * @Version 1.0
 **/

@Configuration
public class InterceptrorConfig implements WebMvcConfigurer {


    @Bean
    public TokenInterceptror tokenInterceptror(){
        return new TokenInterceptror();
    }

    @Bean
    public TrafficInterceptror trafficInterceptror(){
        return new TrafficInterceptror();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptror()).addPathPatterns("/admin/**").excludePathPatterns("/login");
        registry.addInterceptor(trafficInterceptror()).addPathPatterns("/**");
    }

}
