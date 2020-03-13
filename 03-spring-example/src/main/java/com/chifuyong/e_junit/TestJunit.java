package com.chifuyong.e_junit;

import com.chifuyong.a_ioc.d_annotation.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther: chify
 * @Date: 29/02/2020 22:41
 * @Description: Spring 整合 junit
 */
@RunWith(SpringJUnit4ClassRunner.class) //junit 4.12以上
@ContextConfiguration(locations = "classpath:a_ioc/e_annotation.xml")
public class TestJunit {

    @Autowired
    private DemoService demoService;

    @Test
    public void test1(){
        demoService.service();
    }

}
