package com.chifuyong.d_transaction.dao.impl;

import com.chifuyong.d_transaction.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @Auther: chify
 * @Date: 03/03/2020 18:16
 * @Description: 模拟转账 Dao
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    /**
     * 转出
     * @param name
     * @param money
     */
    @Override
    public void out(String name, Integer money) {
        this.getJdbcTemplate().update("update account set money = money - ? where name = ?",money,name);
    }

    /**
     * 转入
     * @param name
     * @param money
     */
    @Override
    public void in(String name, Integer money) {
        this.getJdbcTemplate().update("update account set money = money + ? where name = ?",money,name);
    }
}
