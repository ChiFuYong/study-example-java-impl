package com.chifuyong.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: chify
 * @Date: 22/12/2019 21:23
 * @Description: 拦截器类
 *  AOP 和 拦截器区别
 *      1.AOP 针对特定方法前后添加额外功能
 *      2.拦截器针对点是 Controller 方法
 * 拦截器和 Filter 区别
 *      1. 拦截器只能拦截 SpringMVC 里的 Controller
 *      2. Filter 可以拦截任何请求
 */
public class TestInterceptor  implements HandlerInterceptor {

    /*
    * 进入 Controller 之前执行
    * 返回 false 阻止进入 Controller , 控制代码
    * */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        System.out.println("request:" + request);
        System.out.println(" preHandle 执行完毕......");
        return true;
    }

    /*
    * 控制器执行完成 , 进入到 JSP 之前执行
    * 日志记录 , 敏感词语过滤
    * */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mv) throws Exception {
        System.out.println("跳转的页面为：" + mv.getViewName());
        System.out.println("text内容为:" + mv.getModel().get("text"));
        String word = mv.getModel().get("text").toString();
        //过滤敏感词
        String newWord = word.replace("尼玛", "**");
        mv.getModel().put("text", newWord);
        mv.addObject("origin",word);
        System.out.println(" postHandle 执行完毕......");
    }

    /*
    * JSP 执行完成后执行
    * 记录执行过程中出现的异常 , 可以把异常记录到日志中
    * */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) throws Exception {
        System.out.println(" afterCompletion " + e.getMessage());
        System.out.println(" afterCompletion 执行完毕......");
    }

}