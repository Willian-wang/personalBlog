package com.heiyu.blog.repository;


import com.heiyu.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    public void userUpdate(User user){
        String sql=("UPDATE user_admin SET admin_last_ip=?,admin_last_time=?,admin_gmt_update=? WHERE admin_name=?");
            jdbcTemplate.update(sql, new Object[]{
                    user.getLastIp(),
                    user.getLastLoginTime(),
                    user.getUpdatTime(),
                    user.getUsername()
            });
        }

    public Boolean userWrite(User user) {
        String sql = ("INSERT INTO user_admin() VALUE(?,?,?,?,?,?,?,?,?)");
        int id = publicRepository.getMaxID("user_admin","admin_id")+1;
        try {
            jdbcTemplate.update(sql, new Object[]{
                    id,
                    user.getUsername(),
                    user.getPassword(),
                    user.getCreatTime(),
                    user.getUpdatTime(),
                    user.getEmail(),
                    user.getPhoneNumber(),
                    user.getLastIp(),
                    user.getLastLoginTime()
            });
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public User userRead(String username){
        String sql=("SELECT * FROM user_amdin WHERE username=?;");
        return (User)jdbcTemplate.queryForObject(sql, new Object[]{username}, userRowMapper);
    }

    protected RowMapper userRowMapper = new RowMapper() {
        @Override
        public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            User user = new User();
            user.setEmail(resultSet.getString("admin_email"));
            user.setLastIp(resultSet.getString("admin_last_ip"));
            user.setLastLoginTime(resultSet.getTime("admin_last_time"));
            user.setPhoneNumber(resultSet.getString("admin_phone_number"));
            return user;
        }
    };
}
