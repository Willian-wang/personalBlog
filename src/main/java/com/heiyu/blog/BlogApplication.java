package com.heiyu.blog;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
//import static org.springframework.web.bind.anno
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jayfeather
 * @version 1.0.0
 * @date 2018/12/01
 */
@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}



}


