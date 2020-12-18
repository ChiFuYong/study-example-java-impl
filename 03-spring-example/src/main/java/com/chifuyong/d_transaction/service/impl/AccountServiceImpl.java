package com.chifuyong.d_transaction.service.impl;

import com.chifuyong.d_transaction.dao.AccountDao;
import com.chifuyong.d_transaction.service.AccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


/**
 *
 *
 * @Date: 2020/12/18
 * @author: chify
 */
//类上加注解相当于所有方法加了事务
//@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
//    表示只在此方法上加事务
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public void transfer(String outName, String inName, Integer money) {
        accountDao.out(outName,money);
        //制造报错
        int i = 99/0;
        accountDao.in(inName,money);
    }

    @Override
    public void transfer1(String outName, String inName, Integer money) {
        accountDao.out(outName,money);
        //制造报错
        int i = 99/0;
        accountDao.in(inName,money);
    }
}
