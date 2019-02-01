package com.heiyu.blog.service;

import com.heiyu.blog.domain.Guest;
import com.heiyu.blog.domain.User;
import com.heiyu.blog.repository.PublicRepository;
import com.heiyu.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * @author Jayfeather
 * @version 1.0.0
 * @date  2018/12/15
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PublicRepository publicRepository;

    private Date date =new Date();

    public boolean isLoginMatch(User user) {
        int count;
        Date date =new Date();
        count = userRepository.loginUserMatch(user.getUsername(), user.getPassword());
        if (count > 0) {
            user.setUpdateTime(date);
            user.setLastLoginTime(date);
            userRepository.updateUserLoginInf(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean resignUser (User user){
        Date date =new Date();
        user.setUpdateTime(date);
        user.setCreatTime(date);
        user.setLastLoginTime(date);
        System.out.println(user);
        return userRepository.writeUser(user);
    }

    public boolean updateUserInf(User user){
        user.setUpdateTime(new Date());
        return userRepository.updateUserInf(user);
    }

    public boolean updateUserPassword(User user){
        user.setUpdateTime(new Date());
        return updateUserPassword(user);
    }

    public String readUserList(int pageNum,int pageSize){
        List<User> users = userRepository.readUserList(pageSize,pageNum);
        String userListStr="";
        if(users != null){
            for (User user:users){
                userListStr += user.toString();
            }
            return userListStr;
        }else {
            return null;
        }
    }

    public boolean deletUser(User user){
        user.setUpdateTime(new Date());
        user.setRemove(true);
        return userRepository.deleteUser(user);
    }

    public String readGuestList(int pageNum , int pageSize){
        List<Guest> guests = userRepository.readGuestList(pageSize,pageNum);
        String guestListStr="";
        if(guests != null){
            for (Guest guest:guests){
                guestListStr += guest.toString();
            }
            return guestListStr;
        }else {
            return null;
        }
    }

    public int writeGuest(Guest guest) {
        int count = userRepository.isGuestNameMatch(guest);
        if (count == 0) {
            Date date = new Date();
            guest.setId(publicRepository.getMaxID("user_guest", "guest_id"));
            guest.setUpdateTime(date);
            guest.setCreatTime(date);
            userRepository.writeGuest(guest);
        }return count;
    }

}
