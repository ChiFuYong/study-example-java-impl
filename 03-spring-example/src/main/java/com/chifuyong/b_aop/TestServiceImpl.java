package com.chifuyong.b_aop;

import org.springframework.stereotype.Component;

/**
 * @Auther: chify
 * @Date: 01/03/2020 10:00
 * @Description:
 */
@Component("testService")
public class TestServiceImpl implements TestService{

    @Override
    public void add() {
        System.out.println("add ......");
    }

    @Override
    public void edit() {
        System.out.println("edit ......");
    }

    @Override
    public void commit() {
        System.out.println("commit ......");
    }
}
