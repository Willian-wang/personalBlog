package com.heiyu.blog.service;

import com.heiyu.blog.domain.User;
import com.heiyu.blog.repository.UserRepository;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Jayfeather
 *
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isLoginMatch(User user){
        int count;
        Date date =new Date();
        count = userRepository.LoginUserMatch(user.getUsername(),user.getPassword());
        if(count>0) {
            user.setUpdatTime(date);
            user.setLastLoginTime(date);
            userRepository.UserUpdate(user);
            return true;
        }
        else return false;
    }



    public boolean resignUser(User user){
        Date date =new Date();
        user.setUpdatTime(date);
        user.setCreatTime(date);
        user.setLastLoginTime(date);
        System.out.println(user);
        return userRepository.UserWrite(user);
    }


}
