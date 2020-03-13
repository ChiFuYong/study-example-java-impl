package com.chifuyong.controller.b_annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: chify
 * @Date: 22/12/2019 12:42
 * @Description: AnnotationController类
 */
@Controller
@RequestMapping("/annotation")
public class AnnotationController {

    //在方法上只有@RequestMapping 时,无论方法返回值是什么认为需要跳转
    @RequestMapping("/index")
    public ModelAndView test() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("message","Hello World!");
        return mv;
    }

    /*
     * 在方法上添加 @ResponseBody(恒不跳转)
     *   2.1 如果返回值满足 key-value 形式(对象 或 map)
     *        2.1.1 把响应头设置为 application/json;charset=utf-8
     *        2.1.2 把转换后的内容输出流的形式响应给客户端.
     *   2.2 如果返回值不满足 key-value,例如返回值为 String
     *        2.2.1 把响应头设置为 text/html
     *        2.2.2 把方法返回值以流的形式直接输出.
     *        2.2.3 如果返回值包含中文,出现中文乱码
     *            2.2.3.1 produces 表示响应头中 Content-Type 取值.
     *  注意：底层使用 Jackson 进行 json 转换,需要导入jar依赖
     * */
    @RequestMapping("/responsebody")
//    @RequestMapping(value = "/responsebody",produces ="text/html;charset=utf-8")
    @ResponseBody
    public Map<String,Object> responseBody() {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message","Hello World！");
        return map;
    }

    /*
     * 测试请求转发
     * */
    @RequestMapping("/forward")
    public String forward() {
        System.out.println("请求转发前");
        //方式一："forward:index"
        return "forward:index";
        /*
        //方式二："forward:/annotation/index"（当需要请求转发到别的类的方法时必须用这种方式）
        return "forward:/annotation/index";
        */
    }

    /*
     * 测试重定向
     * */
    @RequestMapping("/redirect")
    public String redirect() {
        System.out.println("重定向前");
        //方式一："redirect:index"
        return "redirect:index";
        /*
        //方式二："redirect:/annotation/index"（当需要重定向到别的类的方法时必须用这种方式）
        return "redirect:/annotation/index";
        */
    }

}
