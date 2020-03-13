package com.chifuyong.a_ioc.a_di;

/**
 * @Auther: chify
 * @Date: 28/02/2020 14:14
 * @Description:
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void helloWorld() {
        System.out.println("UserService：Hello World !");
        userDao.hellWorld();
    }


}
