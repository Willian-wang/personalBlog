package com.heiyu.blog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PublicRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMaxID(String tableName,String idName) {
        int id;
        try{
        String sql="SELECT MAX("+idName+") FROM "+tableName+";";
        id = (int)jdbcTemplate.queryForObject(sql,Integer.class);
        }  catch (Exception e){
            System.out.println(e);
            return 0;
        }
        return id;

    }
}
