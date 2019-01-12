package com.heiyu.blog;

import org.springframework.boot.SpringApplication;
//import static org.springframework.web.bind.anno
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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


