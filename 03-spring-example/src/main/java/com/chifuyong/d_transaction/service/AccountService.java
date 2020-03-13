package com.chifuyong.d_transaction.service;

/**
 * @Auther: chify
 * @Date: 03/03/2020 18:17
 * @Description:
 */
public interface AccountService {

    /*
    * 带事务
    * */
    public void transfer(String outName,String inName, Integer money);

    /*
    * 无事务
    * */
    public void transfer1(String outName,String inName, Integer money);

}
