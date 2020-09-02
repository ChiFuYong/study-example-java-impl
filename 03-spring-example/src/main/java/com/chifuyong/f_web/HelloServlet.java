package com.chifuyong.f_web;

import com.chifuyong.a_ioc.d_annotation.DemoController;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: chify
 * @Date: 28/02/2020 08:56
 * @Description:
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 方式一：从 application 作用域（ServletContext）获取 Spring 容器
        ApplicationContext applicationContext = (ApplicationContext) this.getServletContext()
                .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        DemoController demoController = (DemoController) applicationContext.getBean("demoController");
        demoController.controller();

        // 方式二：通过工具类获取 Spring 容器
        ApplicationContext applicationContext2 = (ApplicationContext) WebApplicationContextUtils
                .getWebApplicationContext(this.getServletContext());
        DemoController demoController1 = (DemoController) applicationContext2.getBean("demoController");
        demoController1.controller();

        String contextConfigLocation = (String) req.getServletContext().getAttribute("contextConfigLocation");
        System.out.println(contextConfigLocation);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
