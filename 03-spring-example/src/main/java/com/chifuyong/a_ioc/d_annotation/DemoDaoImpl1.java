package com.chifuyong.a_ioc.d_annotation;

import org.springframework.stereotype.Repository;

/**
 * @Auther: chify
 * @Date: 29/02/2020 21:34
 * @Description:
 */
@Repository("demoDaoImpl1")
public class DemoDaoImpl1 implements DemoDao{

    @Override
    public void dao() {
        System.out.println("DemoDaoImpl 1 开启...");
    }
}
