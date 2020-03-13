package com.chifuyong.controller.a_xml;

import org.springframework.web.HttpRequestHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: chify
 * @Date: 18/12/2019 17:40
 * @Description: HttpRequestHandler测试类
 */
public class TestHttpRequestHandlerAdapter implements HttpRequestHandler {

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message","Hello World!");
        System.out.println("进入 TestHttpRequestHandlerAdapter。。。。");
    }
}
