package com.chifuyong.controller.c_scope;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther: chify
 * @Date: 05/03/2020 17:20
 * @Description: SpringMVC 作用域传值
 */
@Controller
@RequestMapping("/scope")
public class ScopeController {

    /*
    * 1. 原生 Servlet
    * */
    @RequestMapping("servlet")
    public String servlet(HttpServletRequest request, HttpSession sessionParamter){
        //Request 作用域
        request.setAttribute("request","Request数据");
        //Session 作用域
        HttpSession session = request.getSession();
        sessionParamter.setAttribute("session","Session数据");
        //Application 作用域
        ServletContext application = request.getServletContext();
        application.setAttribute("application","Application数据");
        return "scope";
    }

    /*
    * 2. 使用 Map ,会被放到 Request 域
    * */
    @RequestMapping("map")
    public String map(Map<String,String> map){
        System.out.println(map.getClass());
        map.put("map","Map数据");
        return "/scope";
    }

    /*
    * 3. 使用SpringMVC 中的 Model 类,最终会被放到 Request 域
    * */
    @RequestMapping("model")
    public String model(Model model){
        model.addAttribute("Model","Model数据");
        return "/scope";
    }

    /*
     * 4. 使用SpringMVC 中的 ModelAndView 类,最终会被放到 Request 域
     * */
    @RequestMapping("mav")
    public ModelAndView modelAndView(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("scope");
        mv.addObject("ModelAndView","ModelAndView数据");
        return mv;
    }

}
