package com.heiyu.blog.repository;

import com.heiyu.blog.domain.Comment;
import com.heiyu.blog.domain.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author Jayfeather
 * @date 2019/01/13
 * @version 1.0.
 */
@Repository
public class CommentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean writeComment(Comment comment) {
        String sql = "INSERT INTO content_comment VALUES (?,?,?,?,?,?,?,?)";
        try {
            jdbcTemplate.update(sql, new Object[]{
                    comment.getId(),
                    comment.getArticleId(),
                    comment.getReplayId(),
                    comment.getGuest().getName(),
                    comment.getText(),
                    comment.getUpdateTime(),
                    comment.getCreatTime(),
                    comment.isRemove()
            });
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public List<Comment> readComment(int passageId) {
        String sql = "SELECT * FROM article_comment WHERE comment_article_id=? AND comment_is_remove=0";
        List<Comment> comments = new ArrayList<>();
        try {
            comments =jdbcTemplate.query(sql, new Object[]{passageId}, new RowMapper() {
                @Override
                public Comment mapRow(ResultSet resultSet, int mun) throws SQLException {
                    Comment comment = new Comment();
                    Guest guest = new Guest();
                    comment.setId(resultSet.getInt("comment_id"));
                    guest.setName(resultSet.getString("comment_user_name"));
                    comment.setGuest(guest);
                    comment.setCreatTime(resultSet.getTime("comment_gmt_creaat"));
                    comment.setText(resultSet.getString("comment_content"));
                    comment.setArticleId(resultSet.getInt("comment_article_id"));
                    comment.setReplayId(resultSet.getInt("comment_reply_id"));
                    comment.setRemove(resultSet.getBoolean("comment_is_remove"));
                    comment.setUpdateTime(resultSet.getTime("comment_gmt_update"));
                    return comment;
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
        return comments;
    }

    public boolean deletComment(Comment comment) {
        String sql = "UPDATE article_comment SET comment_is_remove=1,comment_gmt_update=? WHERE comment_id=?";
        try {
            jdbcTemplate.update(sql, new Object[]{
                    comment.getUpdateTime(),
                    comment.getId()
            });
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean updateComment(Comment comment){
            String sql="UPDATE  article_comment SET omment_user_name=?" +
                    ",comment_content=?,comment_article_id=?,comment_reply_id=?" +
                    ",comment_is_remove=?,comment_gmt_update=?" +
                    "WHERE comment_id=?";
            try{
                jdbcTemplate.update(sql,new Object[]{
                        comment.getId(),
                        comment.getGuest().getName(),
                        comment.getText(),
                        comment.getArticleId(),
                        comment.getReplayId(),
                        comment.isRemove(),
                        comment.getUpdateTime()
                });
            }catch(Exception e){
                System.out.println(e);
                return false;
            }
            return true;
    }
}
