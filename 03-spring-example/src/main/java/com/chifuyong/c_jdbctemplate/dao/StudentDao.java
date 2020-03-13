package com.chifuyong.c_jdbctemplate.dao;

import com.chifuyong.c_jdbctemplate.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Auther: chify
 * @Date: 02/03/2020 22:32
 * @Description:
 */
public class StudentDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void update(Student student){
        String sql = "update student set name=?,age=?,sex=? where id = ? ";
        Object[] args = {student.getName(),student.getAge(),student.getSex(),student.getId()};
        jdbcTemplate.update(sql,args);
    }
}
