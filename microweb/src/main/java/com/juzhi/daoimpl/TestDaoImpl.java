package com.juzhi.daoimpl;

import com.juzhi.dao.TestDao;
import com.juzhi.entity.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by xjwan on 5/10/14.
 */
public class TestDaoImpl implements TestDao {
    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;


    @Override
    public void saveHello(Hello hello) {
        String sql = "insert into hello(name) value (?)";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[]{hello.getName()});
    }

    @Override
    public List<Hello> findHelloById(int id) {
        String sql = "select * from hello where id = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
       List<Hello> helloList =  jdbcTemplate.query(sql,new Object[]{id},new RowMapper<Hello>() {
           @Override
           public Hello mapRow(ResultSet rs, int rowNum) throws SQLException {
               Hello hello = new Hello();
               hello.setId(rs.getInt("id"));
               hello.setName(rs.getString("name"));
               return hello;
           }
       });
        return helloList;
    }
}
