package com.chifuyong.a_ioc.a_di;

/**
 * @Auther: chify
 * @Date: 28/02/2020 14:14
 * @Description:
 */
public class UserDaoImpl implements UserDao{

    @Override
    public void hellWorld() {
        System.out.println("UserDao：Hello World !");
    }
}
