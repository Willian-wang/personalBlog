package com.heiyu.blog.repository;

import com.heiyu.blog.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author Jayfeather
 * @date 2019/01/13
 * @version 1.0.
 */
@Repository
public class CommentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean writeComment (Comment comment){
        String sql="INSERT INTO content_comment VALUES (?,?,?,?,?,?,?,?)";
        try{
            jdbcTemplate.update(sql,new Object[]{
                    comment.getId(),
                    comment.getGuest().getName(),
                    comment.getCreatTime(),
                    comment.getText(),
                    comment.getArticleId(),
                    comment.getReplayId(),
                    comment.isRemove(),
                    comment.getUpdateTime()
            });
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public Comment[] getComment(int passageId){
        String sql="";
        Comment comments = new  Comment();
        try{
            comments = jdbcTemplate.queryForObject(sql, new Object[]{}, new RowMapper() {
                @Override
                public Object[] mapRow(ResultSet resultSet) throws SQLException{
                    Comment comment=new Comment();
                    return comment;
                }

            });
        }
    }
}
