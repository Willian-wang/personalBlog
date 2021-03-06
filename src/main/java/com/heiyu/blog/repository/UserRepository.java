package com.heiyu.blog.repository;


import com.heiyu.blog.domain.Guest;
import com.heiyu.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jayfeather
 * @version 1.0.0
 * @date 2018/12/15
 */

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PublicRepository publicRepository;


    public int loginUserMatch(String username, String password){
        String sql=("SELECT COUNT(*) FROM user_admin WHERE admin_name=? and admin_password=?;");
        return (int)jdbcTemplate.queryForObject(sql,new Object[]{username,password}, Integer.class);
    }

    public void updateUserLoginInf(User user){
        String sql=("UPDATE user_admin SET  admin_last_ip=?,admin_last_time=?,admin_gmt_update=? WHERE admin_name=? AND admin_is_remove=0");
            jdbcTemplate.update(sql, new Object[]{
                    user.getLastIp(),
                    user.getLastLoginTime(),
                    user.getUpdateTime(),
                    user.getUsername()
            });
    }

    public boolean updateUserInf(User user){
        String sql="UPDATE user_admin SET admin_email=?,admin_phone_number=?,admin_gmt_update=? WHERE  admin_id=?";
        try {
            jdbcTemplate.update(sql,new Object[]{
                    user.getEmail(),
                    user.getPhoneNumber(),
                    user.getUpdateTime(),
                    user.getId()
            });
        }catch (Exception e){
            System.out.println(e);
            return false;
        }return true;
    }

    public boolean updateUserPassword(User user){
        String sql="UPDATE user_admin SET admin_password=? ,admin_gmt_update=? WHERE  admin_id=?";
        try {
            jdbcTemplate.update(sql,new Object[]{
                    user.getPassword(),
                    user.getUpdateTime(),
                    user.getId()
            });
        }catch (Exception e){
            System.out.println(e);
            return false;
        }return true;
    }

    public Boolean writeUser(User user) {
        String sql = ("INSERT INTO user_admin VALUE(?,?,?,?,?,?,?,?,?,?)");
        try {
            jdbcTemplate.update(sql, new Object[]{
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getPhoneNumber(),
                    user.getEmail(),
                    user.getLastIp(),
                    user.getLastLoginTime(),
                    user.getUpdateTime(),
                    user.getCreatTime(),
                    user.isRemove()
            });
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public List<User> readUserList(int pageSize ,int pageNum){
        String sql = "SELECT * FROM user_admin WHERE admin_is_remove=0 AND admin_id<=" +
                "(SELECT admin_id FROM user_admin LIMIT ?,1) LIMIT ?";
        int firstSelectId=pageSize*(pageNum-1);
        List<User> users = new ArrayList<>();
        try {
            users = jdbcTemplate.query(sql, new Object[]{firstSelectId,pageNum}, new RowMapper() {
                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setId(rs.getInt("admin_id"));
                    user.setUsername(rs.getString("admin_name"));
                    user.setPassword(null);
                    user.setPhoneNumber(rs.getNString("admin_phone_number"));
                    user.setEmail(rs.getString("admin_email"));
                    user.setLastIp(rs.getString("admin_last_ip"));
                    user.setLastLoginTime(rs.getTime("admin_last_time"));
                    user.setUpdateTime(rs.getTime("admin_gmt_update"));
                    user.setCreatTime(rs.getTime("admin_gmt_creat"));
                    return user;
                }
            });
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return users;
    }

    public User readUser(User user){
        String sql=("SELECT * FROM user_admin WHERE admin_name=? AND admin_is_remove = 0;");
        return (User)jdbcTemplate.queryForObject(sql, new Object[]{user.getUsername()}, userRowMapper);
    }

    public boolean deleteUser(User user){
        String sql="UPDATE user_admin SET admin_is_remove=?,admin_gmt_update=? WHERE admin_id=?";
        try {
            jdbcTemplate.update(sql,new Object[]{
                    user.isRemove(),
                    user.getUpdateTime(),
                    user.getId()
            });
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public int isGuestNameMatch(Guest guest){
        String sql="SELECT COUNT(guest_name) FROM user_guest WHERE guest_name=?";
        int count;
        try {
            count = jdbcTemplate.queryForObject(sql,new Object[]{guest.getName()},Integer.class);
        }catch (Exception e){
            System.out.println(e);
            return -1;
        }
        return count;
    }

    public List<Guest> readGuestList(int pageSize,int pageNum) {
        String sql = "SELECT * FROM user_guest WHERE guest_id>=(SELECT article_inf.article_id FROM article_inf WHERE article_is_remove=0 LIMIT ?,1) LIMIT ?";
        int firstSelectId = pageSize*(pageSize-1);
        List<Guest> guests = new ArrayList<>();
        try {
            guests = jdbcTemplate.query(sql, new Object[]{firstSelectId,pageSize}, new RowMapper() {
                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Guest guest = new Guest();
                    guest.setId(rs.getInt("guest_id"));
                    guest.setName(rs.getString("guest_name"));
                    guest.setEmail(rs.getString("guest_email"));
                    guest.setIp(rs.getString("guest_ip"));
                    guest.setCreatTime(rs.getTime("guest_gmt_creat"));
                    guest.setUpdateTime(rs.getTime("guest_gmt_update"));
                    guest.setBlog(rs.getString("guest_blog"));
                    return guest;
                }
            });
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return guests;
    }

    public boolean writeGuest(Guest guest){
            String sql1="INSERT INTO user_guest VALUES (?,?,?,?,?,?,?)";
            try {
            jdbcTemplate.update(sql1,new Object[]{
                    guest.getId(),
                    guest.getName(),
                    guest.getIp(),
                    guest.getBlog(),
                    guest.getEmail(),
                    guest.getCreatTime(),
                    guest.getUpdateTime()
            });}catch (Exception e){
                System.out.println(e);
                return false;
            }

            return true;
        }

    protected RowMapper userRowMapper = new RowMapper() {
        @Override
        public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("admin_id"));
            user.setUsername(resultSet.getString("admin_name"));
            user.setEmail(resultSet.getString("admin_email"));
            user.setLastIp(resultSet.getString("admin_last_ip"));
            user.setLastLoginTime(resultSet.getTimestamp("admin_last_time"));
            user.setPhoneNumber(resultSet.getString("admin_phone_number"));
            return user;
        }
    };
}

