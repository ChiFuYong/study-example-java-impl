package cn.chifuyong;

import cn.chifuyong.entity.AdminUser;
import cn.chifuyong.mapper.AdminUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis Demo 类
 *
 * @date： 2020/12/3
 * @author: chify
 */
public class MyBatisDemo {

    @Test
    public void test() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        //1.建造者模式获取 SqlSeesion 工厂对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(is);
        //2.工厂模式获取 SqlSession 对象
        SqlSession sqlSession = sessionFactory.openSession();
        //3.获取 Dao 层对象
        AdminUserDao mapper = (AdminUserDao)sqlSession.getMapper(AdminUserDao.class);
        //4.执行数据库查询获取相应实体类对象
        AdminUser adminUser = mapper.selectByPrimaryKey(1);

    }

}
