package com.heiyu.blog.repository;

import com.heiyu.blog.domain.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.heiyu.blog.repository.PublicRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName nedoRepository
 * @Description FINISH
 * @Author Jayfeather
 * @Date 2019/1/29 22:20
 * @Version 1.0
 *
 * 这个类尝试了一下使用公共update代码，减少了代码量……，但是代码的可读性降低了。
 **/
public class NodeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PublicRepository publicRepository;

    public boolean writeNode(Node node) {
        String sql1 = "INSERT INTO article_node VALUES (?,?,?,?,?,?,?)";
        try {
            jdbcTemplate.update(sql1, new Object[]{
                    node.getId(),
                    node.getName(),
                    node.getUpdateTime(),
                    node.getCreatTime(),
                    node.isRemove()
            });
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public List<Node> readNodeList(int pageSize, int pageNum) {
        String sql = "SELECT * FROM article_node WHERE node_is_remove=0 AND " +
                "node_id>=(SELECT article_inf.article_id FROM article_inf WHERE article_is_remove=0 LIMIT ?,1) LIMIT ?";
        int firstSelectId = pageSize * (pageNum - 1);
        List<Node> nodes = new ArrayList<>();
        try {
            nodes = jdbcTemplate.query(sql, new Object[]{firstSelectId, pageNum}, new RowMapper() {
                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Node node = new Node();
                    node.setId(rs.getInt("node_id"));
                    node.setName(rs.getString("node_name"));
                    node.setUpdateTime(rs.getDate("node_gmt_update"));
                    node.setCreatTime(rs.getDate("node_gmt_creat"));
                    node.setRemove(rs.getBoolean("node_is_remove"));
                    return node;
                }
            });
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return nodes;
    }

    public boolean deleteNode(Node node) {
        String sql = "UPDATE article_node SET node_is_remove=?,node_gmt_update=? WHERE node_id=?";
        Object object = new Object[]{
                node.isRemove(),
                node.getUpdateTime(),
                node.getId()
        };
        return publicRepository.publicUpdate(sql, object);
    }

    public boolean updateNode(Node node) {
        String sql = "UPDATE article_node SET node_name=?,node_gmt_update=?,node_gmt_creat=?,node_is_remove=? WHERE node_id=?";
        Object object = new Object[]{
                node.getName(),
                node.getUpdateTime(),
                node.getCreatTime(),
                node.isRemove(),
                node.getId()
        };
        return publicRepository.publicUpdate(sql, object);
    }


}
