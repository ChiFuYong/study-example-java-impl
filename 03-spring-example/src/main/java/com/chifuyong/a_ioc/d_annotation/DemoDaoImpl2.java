package com.chifuyong.a_ioc.d_annotation;

import org.springframework.stereotype.Repository;

/**
 * @Auther: chify
 * @Date: 29/02/2020 21:37
 * @Description:
 */
@Repository("demoDaoImpl2")
public class DemoDaoImpl2 implements DemoDao{

    @Override
    public void dao() {
        System.out.println("DemoDaoImpl 2 开启...");
    }
}
