package com.chifuyong.c_jdbctemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.chifuyong.c_jdbctemplate.dao.StudentDao;
import com.chifuyong.c_jdbctemplate.dao.StudentJdbcDaoSupport;
import com.chifuyong.c_jdbctemplate.entity.Student;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * @Auther: chify
 * @Date: 02/03/2020 15:28
 * @Description:
 */
public class TestJdbcTemplateDemo {

    /*
    * JdbcTemplate 使用 dbcp 数据源
    * */
    @Test
    public void testDBCP(){
        //dbcp 数据源
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/study");
        dataSource.setUsername("root");
        dataSource.setPassword("0607");
        //jdbc Template
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        jdbcTemplate.update("insert into student(name,age,sex) values(?,?,?);","光","26","男");
    }

    /*
     * JdbcTemplate 使用 cp30 数据源
     * */
    @Test
    public void testCP30() throws PropertyVetoException {
        //druid 数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/study");
        dataSource.setUser("root");
        dataSource.setPassword("0607");
        //jdbc Template
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        jdbcTemplate.update("insert into student(name,age,sex) values(?,?,?);","光","26","男");
    }

    /*
     * JdbcTemplate 使用 druid 数据源
     * */
    @Test
    public void testDruid(){
        //cp30 数据源
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/study");
        dataSource.setUsername("root");
        dataSource.setPassword("0607");
        //jdbc Template
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        jdbcTemplate.update("insert into student(name,age,sex) values(?,?,?);","光","26","男");
    }

    /*
    * dbcp ioc 测试
    * */
    @Test
    public void dbcp(){
        String xmlPath = "c_jdbctemplate/a_dao.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Student student = new Student();
        student.setId(1);
        student.setName("test");
        student.setAge(43);
        student.setSex("男");
        StudentDao studentDao = (StudentDao) applicationContext.getBean("dbcpDao");
        studentDao.update(student);
    }

    /*
    * cp30 ioc 测试
    * */
    @Test
    public void cp30(){
        String xmlPath = "c_jdbctemplate/a_dao.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Student student = new Student();
        student.setId(2);
        student.setName("test");
        student.setAge(41);
        student.setSex("男");
        StudentDao studentDao = (StudentDao) applicationContext.getBean("cp30Dao");
        studentDao.update(student);
    }

    /*
    * druid ioc 测试
    * */
    @Test
    public void druid(){
        String xmlPath = "c_jdbctemplate/a_dao.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Student student = new Student();
        student.setId(2);
        student.setName("test");
        student.setAge(40);
        student.setSex("男");
        StudentDao studentDao = (StudentDao) applicationContext.getBean("druidDao");
        studentDao.update(student);
    }

    /*
    * dbcp JdbcDaoSupport 测试
    * */
    @Test
    public void dbcpDaoSupport(){
        String xmlPath = "c_jdbctemplate/b_daosupport.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Student student = new Student();
        student.setId(1);
        student.setName("test");
        student.setAge(48);
        student.setSex("男");
        StudentJdbcDaoSupport studentDao = (StudentJdbcDaoSupport) applicationContext.getBean("dbcpDao");
        studentDao.update(student);
    }

    /*
    * cp30 JdbcDaoSupport 测试
    * */
    @Test
    public void cp30DaoSupport(){
        String xmlPath = "c_jdbctemplate/b_daosupport.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Student student = new Student();
        student.setId(2);
        student.setName("test");
        student.setAge(48);
        student.setSex("男");
        StudentJdbcDaoSupport studentDao = (StudentJdbcDaoSupport) applicationContext.getBean("cp30Dao");
        studentDao.update(student);
    }


}
