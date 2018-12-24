package com.heiyu.blog.repository;


import com.heiyu.blog.domain.User;
import com.mysql.cj.result.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.heiyu.blog.domain.LoginUser;

import javax.validation.constraints.Email;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jayfeather
 *
 */

@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public int LoginUserMatch (String username,String password){
        String sql=("SELECT COUNT(*) FROM user_admin WHERE admin_name=? and admin_password=?;");
        return (int)jdbcTemplate.queryForObject(sql,new Object[]{username,password}, Integer.class);
    }

    public void UserWrite(User user){
        String sql=("INSERT INTO user_admin VALUE(?,?,?,?,?,?,?,?)");
        jdbcTemplate.update(sql,new Object[]{
                user.getUsername(),
                user.getPassword(),
                user.getCreatTime(),
                user.getUpdatTime(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getLastIp(),
                user.getLastLoginTime()
        });

    }

    public User UserRead(String username){
        String sql=("SELECT * FROM user_amdin WHERE username=?;");
        return (User)jdbcTemplate.queryForObject(sql, new Object[]{username}, UserRowMapper);
    }

    protected RowMapper UserRowMapper = new RowMapper() {
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
