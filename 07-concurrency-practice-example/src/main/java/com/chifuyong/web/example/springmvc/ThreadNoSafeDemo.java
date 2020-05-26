package com.chifuyong.web.example.springmvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全示例
 *
 * @date： 2020/4/19
 * @author: chify
 */
public class ThreadNoSafeDemo implements Runnable{

    /**
     * 模拟 SpringMVC 里的 DispatcherServlet
     */
    private DispatcherServlet dispatcherServlet = DispatcherServlet.getInstance();

    public void run() {
        //模拟请求路径
        List<String> requestList = new ArrayList<String>();
        requestList.add("/about");
        requestList.add("/index");
        for(int i = 0 ; i < 999; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //随遍访问一个 Controller
            String requestUrl = requestList.get( i % 2 );
            dispatcherServlet.invokeController(requestUrl);
        }
    }

}
