package com.chifuyong.web.example.springmvc;

/**
 * SpringMVC 中 DispatcherServlet 模拟
 *
 * @date： 2020/4/15
 * @author: chify
 */
public class DispatcherServlet {

    /**
     * 单实例(饿汉式单例)
     */
    private static DispatcherServlet servlet = new DispatcherServlet();

    /**
     * 模拟第一个 Controller（Spring 中 bean 默认是单例的，Controller 中实现单例模式）
     */
    private IndexController indexController = IndexController.getInstance();

    /**
     * 模拟第二个 Controller（Spring 中 bean 默认是单例的，Controller 中实现单例模式）
     */
    private AboutController aboutController = AboutController.getInstance();

    private DispatcherServlet(){}

    /**
     * 返回一个单例的 Servlet 对象
     * @return
     */
    public static DispatcherServlet getInstance(){
        return servlet;
    }

    /**
     * 模拟 DispatcherServlet 调用 Controller
     */
    public void invokeController(String request){
        if ("/index".equals(request)){
            indexController.addVisitNumber();
            System.out.println("IndexController 被访线程：" + Thread.currentThread().getName()
                    + "访问一次，当前访问次数为：" + indexController.getVisitNumber());
        }
        if ("/about".equals(request)){
            aboutController.addVisitNumber();
            System.out.println("AboutController 被访线程：" + Thread.currentThread().getName()
                    + "访问一次，当前访问次数为：" + aboutController.getVisitNumber());
        }
    }

}
