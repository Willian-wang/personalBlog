package com.heiyu.blog.repository;

import com.heiyu.blog.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LogRepository
 * @Description TODO
 * @Author Jayfeather
 * @Date 2019/2/28 10:20
 * @Version 1.0
 **/
@Repository
public class LogRepository {

    @Autowired
    PublicRepository publicRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

        public boolean writeLog(Log log){
                String sql1="INSERT INTO sys_log VALUES (?,?,?,?,?,?,?)";
                try {
                jdbcTemplate.update(sql1,new Object[]{
                        log.getId()+1,
                        log.getUserName(),
                        log.getIp(),
                        log.getOperate(),
                        log.getUrl(),
                        log.getGmtUpdateTime(),
                        log.getGmtCreatTime()
                });}catch (Exception e){
                    System.out.println(e);
                    return false;
                }

                return true;
            }


            public List<Log> readLogList(int page)
            {
                int PAGESIZE = 25;
                int beginPage= (page-1)*PAGESIZE;
                String sql = "SELECT * FROM  sys_log LIMIT(?,?)";
                List<Log> logs = new ArrayList<>();
                try {
                    logs = jdbcTemplate.query(sql, new Object[]{beginPage,PAGESIZE}, new RowMapper() {
                        @Override
                        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                            Log log = new Log();
                            log.setId(rs.getInt("id"));
                            log.setUserName(rs.getString("log_user"));
                            log.setOperate(rs.getString("log_operate"));
                            log.setUrl(rs.getString("log_url"));
                            log.setGmtUpdateTime(rs.getDate("log_gmt_update"));
                            log.setGmtCreatTime(rs.getDate("log_gmt_creat"));
                            return log;
                        }
                    });
                } catch (Exception e) {
                    System.out.println(e);
                    return null;
                }
                return logs;
            }
}
