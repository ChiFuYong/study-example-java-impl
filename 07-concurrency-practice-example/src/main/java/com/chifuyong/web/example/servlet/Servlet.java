package com.chifuyong.web.example.servlet;

/**
 * 单实例 servlet 模拟
 *
 * @date： 2020/4/15
 * @author: chify
 */
public class Servlet {

    /**
     * 单实例(饿汉式单例)
     */
    private static Servlet servlet = new Servlet();

    /**
     * 模拟此 Servlet 被访问的总次数
     * 因为 Servletc 是单实例的，所以在多线程中调用此状态（指visitNumber）将是不安全的
     */
    private int visitNumber = 0;

    private Servlet(){}

    /**
     * 返回一个单例的 Servlet 对象
     * @return
     */
    public static Servlet getInstance(){
        return servlet;
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
