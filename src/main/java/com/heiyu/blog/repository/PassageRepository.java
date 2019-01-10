package com.heiyu.blog.repository;

import com.heiyu.blog.domain.Passage;
import org.hibernate.engine.spi.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PassageRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PublicRepository publicRepository;

    public boolean writePassageInf(Passage passage){
        String sql="INSERT INTO article_inf VALUES (?,?,?,?,?,?,?)";
        try {
        jdbcTemplate.update(sql,new Object[]{
                passage.getId(),
                passage.getTitle(),
                passage.getAuthor(),
                passage.getNodeId(),
                passage.getCreatTime(),
                passage.getUpdateTime(),
                passage.isRemove()
        });}
        catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean writePassageText(Passage passage){
        String sql = "INSERT INTO article_text VALUES (?,?)";
        try {
            jdbcTemplate.update(sql,new Object[]{
                passage.getId(),
                passage.getText()
            });}
        catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean deletePassage(Passage passage){
        String sql="UPDATE article_inf SET article_is_remove=?,article_gmt_update=? WHERE article_title=?";
        try {
            jdbcTemplate.update(sql,new Object[]{
                    passage.isRemove(),
                    passage.getUpdateTime(),
                    passage.getTitle()
            });
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public Passage readPassageText(String name){
        String sql_1="SELECT article_title,article_author,node_id,article_gmt_creat,article_gmt_update FROM article_inf WHERE article_title=? AND article_is_remove=0";
        String sql_2="SELECT article_content FROM article_text WHERE article_title = ?";
        Passage passage;
        try{
            passage=(Passage)jdbcTemplate.queryForObject(sql_1, new Object[]{name}, new RowMapper() {
                @Override
                public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                    Passage passage=new Passage();
                    passage.setId(resultSet.getInt("comment_id"));
                    passage.setAuthor(resultSet.getString("comment_user_name"));
                    passage.setNodeId(resultSet.getInt("node_id"));
                    passage.setCreatTime(resultSet.getTime("article_gmt_creat"));
                    passage.setUpdateTime(resultSet.getTime("article_gmt_update"));
                    return passage;
                }
            });
        }catch (Exception e){
            System.out.println(e);
            System.out.println("第一个SQL写入错误");
            return null;
        }
        try {
            passage.setText((String)jdbcTemplate.queryForObject(sql_2, new Object[]{passage.getTitle()},String.class));
        }catch (Exception e) {
            System.out.println(e);
            System.out.println("第二个SQL写入错误");
            return null;
        }
        return passage;
    }

    public boolean updatePassage(Passage passage){
        String sql="UPDATE article_inf SET ";
        try{
            jdbcTemplate.update(sql,new Object[]{

            });
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
}
