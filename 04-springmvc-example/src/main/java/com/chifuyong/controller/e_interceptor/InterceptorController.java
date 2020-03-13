package com.chifuyong.controller.e_interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: chify
 * @Date: 05/03/2020 23:28
 * @Description:
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

    @RequestMapping("interceptor")
    public ModelAndView interceptor(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("interceptor");
        mv.addObject("text","不可以随便说脏话,比如说：尼玛！");
        return mv;
    }

}
