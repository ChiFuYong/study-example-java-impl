package com.chifuyong.d_transaction.dao;

/**
 * @Auther: chify
 * @Date: 03/03/2020 18:15
 * @Description:
 */
public interface AccountDao {

    public void out(String name ,Integer money);

    public void in(String name,Integer money);
}
