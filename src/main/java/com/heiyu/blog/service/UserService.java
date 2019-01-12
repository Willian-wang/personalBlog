package com.heiyu.blog.service;

import com.heiyu.blog.domain.User;
import com.heiyu.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Jayfeather
 * @version 1.0.0
 * @date  2018/12/15
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private Date date =new Date();

    public boolean isLoginMatch(User user) {
        int count;
        Date date =new Date();
        count = userRepository.loginUserMatch(user.getUsername(), user.getPassword());
        if (count > 0) {
            user.setUpdatTime(date);
            user.setLastLoginTime(date);
            userRepository.userUpdate(user);
            return true;
        } else {
            return false;
        }
    }



    public boolean resignUser (User user){
        Date date =new Date();
        user.setUpdatTime(date);
        user.setCreatTime(date);
        user.setLastLoginTime(date);
        System.out.println(user);
        return userRepository.userWrite(user);
    }


}
