package com.chifuyong.controller.b_annotation;

import com.chifuyong.entity.Request;
import com.chifuyong.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: chify
 * @Date: 05/03/2020 15:39
 * @Description: 参数封装测试
 */

@Controller
@RequestMapping("/parameter")
public class ParamterController {

    /*
     * 跳转到测试表单页
     * */
    @RequestMapping("/formpage")
    public ModelAndView formpage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("formpage");
        return mv;
    }

    /*
     * 传递基本类型参数
     * 1. 默认保证参数名称和请求中传递的参数名相同，否则
     * 2. 使用 @RequestParam()进行赋值
     *       defaultValue 设置默认值，防止报 500
     *       required 要求必须输入,默认为false
     * */
    @RequestMapping(value = "/test1",produces ="text/html;charset=utf-8")
    @ResponseBody
    public String test1(String name,  @RequestParam(value="age",defaultValue = "30",required = false)int int1) {
        String str = "name:"+name+",  age:"+int1;
        System.out.println(str);
        return "成功！";
    }


    /*
    * 传递数组：复选框 checkbox
    * */
    @RequestMapping(value = "/test11",produces ="text/html;charset=utf-8")
    @ResponseBody
    public String test11(String[] hobby) {
        String str = "爱好为: ";
        for(int i=1;i<hobby.length;i++){
            System.out.println(hobby[i]);
        }
        return "成功！";
    }

    /*
     * 传递 POJO 对象
     * */
    @RequestMapping(value = "/test2",produces ="text/html;charset=utf-8")
    @ResponseBody
    public String test2(Student student) {
        System.out.println(student);
        return "成功！";
    }

    /*
     * 传递包装参数 Request：包含 POJO 对象, List,Map 集合
     * */
    @RequestMapping(value = "/test3",produces ="text/html;charset=utf-8")
    @ResponseBody
    public String test3(Request request) {
        System.out.println(request);
        return "成功！";
    }

    /*
     * restful 传递参数（前后端分离）
     * */
    @RequestMapping(value = "/test4/{id}/{name}",produces ="text/html;charset=utf-8")
    @ResponseBody
    public String test4(@PathVariable String name, @PathVariable("id") int int1) {
        String str = "name:"+name+",  id:"+int1;
        System.out.println(str);
        return "成功！";
    }
}
