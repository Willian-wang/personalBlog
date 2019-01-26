package com.heiyu.blog.repository;

import com.heiyu.blog.domain.Passage;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.hibernate.engine.spi.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Null;
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
public class PassageRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PublicRepository publicRepository;

    public boolean writePassage(Passage passage){
        String sql1="INSERT INTO article_inf VALUES (?,?,?,?,?,?,?)";
        String sql2="INSERT INTO article_text VALUES (?,?,?)";
        try {
        jdbcTemplate.update(sql1,new Object[]{
                passage.getId(),
                passage.getTitle(),
                passage.getAuthor(),
                passage.getNodeId(),
                passage.getCreatTime(),
                passage.getUpdateTime(),
                passage.isRemove()
        });
            jdbcTemplate.update(sql2,new Object[]{
                    passage.getId(),
                    passage.getTitle(),
                    passage.getText()
            });}catch (Exception e){
            System.out.println(e);
            return false;
        }

        return true;
    }

    public boolean deletePassage(Passage passage){
        String sql="UPDATE article_inf SET article_is_remove=?,article_gmt_update=? WHERE article_id=?";
        try {
            jdbcTemplate.update(sql,new Object[]{
                    passage.isRemove(),
                    passage.getUpdateTime(),
                    passage.getId()
            });
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public Passage readPassageText(String name){
        String sql1="SELECT article_title,article_author,node_id,article_gmt_creat,article_gmt_update FROM article_inf WHERE article_title=? AND article_is_remove=0";
        String sql2="SELECT article_content FROM article_text WHERE article_title = ?";
        Passage passage;
        try{
            passage=(Passage)jdbcTemplate.queryForObject(sql1, new Object[]{name}, new RowMapper() {
                @Override
                public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                    Passage passage=new Passage();
                    passage.setId(resultSet.getInt("comment_id"));
                    passage.setAuthor(resultSet.getString("comment_user_name"));
                    passage.setNodeId(resultSet.getInt("node_id"));
                    passage.setCreatTime(resultSet.getTime("article_gmt_creat"));
                    passage.setUpdateTime(resultSet.getTime("article_gmt_update"));
                    return passage;
                }});
            passage.setText((String)jdbcTemplate.queryForObject(sql2, new Object[]{passage.getTitle()},String.class));
        }catch (Exception e){
            System.out.println(e);
            System.out.println("SQL写入错误");
            return null;
        }
        return passage;
    }

    public boolean updatePassage(Passage passage){
        String sql1="UPDATE article_inf SET article_title=?,article_author=?,node_id=?,article_gmt_update=? WHERE article_id=?";
        String sql2="UPDATE article_text SET article_title=? , article_content=? WHERE article_id=?";
        try{
            jdbcTemplate.update(sql1,new Object[]{
                    passage.getTitle(),
                    passage.getAuthor(),
                    passage.getNodeId(),
                    passage.getUpdateTime(),
                    passage.getId(),
            });
            jdbcTemplate.update(sql2,new Object[]{
                    passage.getTitle(),
                    passage.getText(),
                    passage.getId()
            });
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public List<Passage> getPassageList(int page,int pageSize){
        String sql1="SELECT * FROM article_inf WHERE article_is_remove=0 and article_id >= ? LIMIT ?";
        String sql2="SELECT * FROM";
        int firstSelectedId = ( ( page - 1) * pageSize);
        List<Passage> passages = new ArrayList<>();
        try{
            passages=jdbcTemplate.query(sql1,new Object[]{firstSelectedId,pageSize }, new RowMapper() {
                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Passage passage = new Passage();
                    passage.setId(rs.getInt("article_id"));
                    passage.setTitle(rs.getString("article_title"));
                    passage.setAuthor(rs.getString("article_author"));
                    passage.setNodeId(rs.getInt("node_id"));
                    passage.setCreatTime(rs.getTime("article_gmt_creat"));
                    passage.setUpdateTime(rs.getTime("article_gmt_update"));
                    passage.setRemove(rs.getBoolean("article_is_remove"));
                    return passage;
                }
            });
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
        return passages;
    }
}
