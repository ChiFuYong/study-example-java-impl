package com.chifuyong.web.example.springmvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全示例
 *
 * @date： 2020/4/19
 * @author: chify
 */
public class ThreadSafeDemo extends Thread{

    /**
     * 模拟 SpringMVC 里的 DispatcherServlet
     */
    private DispatcherServlet dispatcherServlet = DispatcherServlet.getInstance();

    /**
     * 锁对象
     */
    private String lock = "lock";

    @Override
    public void run() {
        //模拟请求路径
        List<String> requestList = new ArrayList<String>();
        requestList.add("/about");
        requestList.add("/index");
        for(int i = 0 ; i < 999; i++){
            synchronized (lock){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //随便访问一个 Controller
                String requestUrl = requestList.get( i % 2 );
                dispatcherServlet.invokeController(requestUrl);
            }
        }
    }

}
