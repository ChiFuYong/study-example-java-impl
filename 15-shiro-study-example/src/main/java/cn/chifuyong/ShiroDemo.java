package cn.chifuyong;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * shiro 学习Demo
 *
 * @date： 2020/12/3
 * @author: chify
 */
public class ShiroDemo {

    /**
     * Hello World 入门案例
     */
    @Test
    public void helloWorld(){
        //1.构建SecurityManager工厂，IniSecurityManagerFactory可以从ini文件中初始化SecurityManager环境
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:ini/shiro.ini");
        //2.通过工厂获得SecurityManager实例
        SecurityManager securityManager = factory.getInstance();
        //3.将SecurityManager实例设置到运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        //4.获取subject实例
        Subject subject = SecurityUtils.getSubject();
        //5.创建用户名,密码身份验证Token
        UsernamePasswordToken token = new UsernamePasswordToken("chify", "0607");
        try {
            //登录，即身份验证
            subject.login(token);
            //可用于判断是否身份认证通过
            if (subject.isAuthenticated()){
                System.out.println("验证通过！");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            //身份认证失败,AuthenticationException还有更多继承了他的子类认证异常
            System.out.println("身份认证失败！");
        }
        //退出
        subject.logout();
    }

    /**
     * jdbcRealmTest
     */
    @Test
    public void jdbcRealmTest(){
        //1.构建SecurityManager工厂，IniSecurityManagerFactory可以从ini文件中初始化SecurityManager环境
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:ini/jdbcRealm.ini");
        //2.通过工厂获得SecurityManager实例
        SecurityManager securityManager = factory.getInstance();
        //3.将SecurityManager实例设置到运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        //4.获取subject实例
        Subject subject = SecurityUtils.getSubject();
        //5.创建用户名,密码身份验证Token
        UsernamePasswordToken token = new UsernamePasswordToken("chify", "0607");
        try {
            //登录，即身份验证
            subject.login(token);
            //可用于判断是否身份认证通过
            if (subject.isAuthenticated()){
                System.out.println("验证通过！");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            //身份认证失败,AuthenticationException还有更多继承了他的子类认证异常
            System.out.println("身份认证失败！");
        }
        //退出
        subject.logout();
    }


}
