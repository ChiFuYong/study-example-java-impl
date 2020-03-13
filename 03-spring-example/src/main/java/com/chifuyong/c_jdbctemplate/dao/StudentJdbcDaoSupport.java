package com.chifuyong.c_jdbctemplate.dao;

import com.chifuyong.c_jdbctemplate.entity.Student;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @Auther: chify
 * @Date: 02/03/2020 23:24
 * @Description:
 */
public class StudentJdbcDaoSupport extends JdbcDaoSupport {

    public void update(Student student){
        String sql = "update student set name=?,age=?,sex=? where id = ? ";
        Object[] args = {student.getName(),student.getAge(),student.getSex(),student.getId()};
        this.getJdbcTemplate().update(sql,args);
    }

}
