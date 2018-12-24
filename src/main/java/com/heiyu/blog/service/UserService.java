package com.heiyu.blog.service;

import com.heiyu.blog.domain.User;
import com.heiyu.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isLoginMatch(User user){
        return userRepository.LoginUserMatch(user.getUsername(),user.getPassword())>0;
    }

    public void resignUser(User user){


        userRepository.UserWrite(user);
    }
    /**  TODO 注册功能对象User的字段补全，并且写入数据库
     *
     */
}
