package com.chifuyong.d_transaction.service.impl;

import com.chifuyong.d_transaction.dao.AccountDao;
import com.chifuyong.d_transaction.service.AccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Auther: chify
 * @Date: 03/03/2020 18:26
 * @Description: 手动管理事务
 */
public class AccountServiceManualImpl implements AccountService {

    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    //添加 事物模版 属性
    private TransactionTemplate transactionTemplate;
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public void transfer(final String outName, final String inName, final Integer money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.out(outName,money);
                //制造报错
                int i = 99/0;
                accountDao.in(inName,money);
            }
        });
    }

    @Override
    public void transfer1(String outName, String inName, Integer money) {
        accountDao.out(outName,money);
        //制造报错
        int i = 99/0;
        accountDao.in(inName,money);
    }
}
