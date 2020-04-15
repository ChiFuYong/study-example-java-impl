package com.chifuyong.a_ioc.b_factory;

import com.chifuyong.a_ioc.Service;
import com.chifuyong.a_ioc.ServiceImpl;

/**
 * @Auther: chify
 * @Date: 28/02/2020 14:40
 * @Description:
 */
public class Factory {

    /*
    * 静态工厂方式装配 Bean
    * */
    public static Service createService(){
        return new ServiceImpl();
    }

    /*
    * 实例工厂方式装配 Bean
    * */
    public Service createService2(){
        return new ServiceImpl();
    }

}
