package com.chifuyong.web.example.springmvc;

/**
 * 单实例 SpringMVC 中 Controller 模拟
 * 假设跳转到 Controller,就加一次访问量
 *
 * @date： 2020/4/15
 * @author: chify
 */
public class AboutController {

    /**
     * 单实例（饿汉式）
     */
    private static AboutController aboutController = new AboutController();

    /**
     * 模拟此 Controller 被访问的总次数
     * 因为 DispatcherServlet 也是 Servlet， 是单例的，
     * Controller 在 Spring bean 中默认也是单实例的，所以多线程调用此状态（指 visitNumber）将是不安全的
     */
    private int visitNumber = 0;

    private AboutController(){}

    /**
     * spring 和 springmvc 中 bean 默认是单例的，这里模拟出一个单例的 Controller
     * @return
     */
    public static AboutController getInstance(){
        return aboutController;
    }

    /**
     * 增加一次访问量
     */
    public int addVisitNumber(){
        visitNumber++;
        return visitNumber;
    }

    public int getVisitNumber() {
        return visitNumber;
    }

}
