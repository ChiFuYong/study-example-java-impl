package com.chifuyong.a_ioc.d_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Auther: chify
 * @Date: 29/02/2020 21:32
 * @Description:
 */
@Controller("demoController")
public class DemoController {

    /*
    * 默认按类型注入，假如说有两个接口的实现
    * DemoService 必须只能有一个能被扫描到的有 @Component 注解的实现类,否则得按名称来注入.
    * */
    @Autowired
    private DemoService demoService;

    public void controller(){
        demoService.service();
    }

}
