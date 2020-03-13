package com.chifuyong.d_transaction;

import com.chifuyong.d_transaction.dao.AccountDao;
import com.chifuyong.d_transaction.service.AccountService;
import com.chifuyong.d_transaction.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: chify
 * @Date: 03/03/2020 21:16
 * @Description:
 */
public class TestTransactionDemo {

    /*
    * 无事务
    * */
    @Test
    public void noTransaction(){
        String xmlPath = "d_transaction/a_transaction.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setAccountDao(accountDao);
        accountService.transfer("xm","xh",100);
    }

    /*
    * 手动配置
    * */
    @Test
    public void impl1(){
        String xmlPath = "d_transaction/a_transaction.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        //带事务
        accountService.transfer("xm","xh",100);
        //无事务
//        accountService.transfer1("xm","xh",100);
    }

    /*
    * 半自动
    * */
    @Test
    public void impl2(){
        String xmlPath = "d_transaction/b_transaction.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        AccountService accountService = (AccountService) applicationContext.getBean("proxyAccountService");
        //带事务
        accountService.transfer("xm","xh",100);
        //无事务
//        accountService.transfer1("xm","xh",100);
    }

    /*
     * xml 配置
     * */
    @Test
    public void impl3(){
        String xmlPath = "d_transaction/c_transaction.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        //带事务
//        accountService.transfer("xm","xh",100);、
        //无事务
        accountService.transfer1("xm","xh",100);
    }

    /*
     * annotation 配置
     * */
    @Test
    public void impl4(){
        String xmlPath = "d_transaction/d_transaction.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        //带事务
//        accountService.transfer("xm","xh",100);
        //无事务
        accountService.transfer1("xm","xh",100);
    }


}
