package com.chifuyong.controller.d_file_down_up_load;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: chify
 * @Date: 05/03/2020 19:23
 * @Description:
 */
@Controller
@RequestMapping("/file")
public class FileUpLoadAndDownLoadController {

    /**
     * 页面跳转
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }


    /*
    * 文件下载
    * */
    @RequestMapping("/download")
    public void download(HttpServletResponse response, HttpServletRequest request) throws IOException {

        //获取当前类的 classpath 根路径 -> file:/opt/apache-tomcat-8.5.43/webapps/SpringMVC_war/WEB-INF/classes/
        String classPath = this.getClass().getResource("/").toString();
        System.out.println("classPath = " + classPath);
        //获取当前类的路径 -> /opt/apache-tomcat-8.5.43/webapps/SpringMVC_war/WEB-INF/classes/com/chifuyong/controller/d_file_down_up_load/
        String classPath2 = this.getClass().getResource("").getPath();
        System.out.println("classPath2 = " + classPath2);
        //获取部署后的真实路径 -> /opt/apache-tomcat-8.5.43/webapps/SpringMVC_war/files
        String realPath = request.getServletContext().getRealPath("files");
        System.out.println("realPath = " + realPath);

        File file = new File(realPath, "test.txt");
        //设置响应信息
        /*
        * 1.访问资源时相应头如果没有设置 Content-Disposition,浏览器默认按照 inline 值进行处理
        *    1.1 inline 能显示就显示,不能显示就下载.
        * 2.只需要修改相应头中 Context-Disposition=”attachment;filename=文件名”
        *    2.1 attachment 下载,以附件形式下载.
        *    2.2 filename=值就是下载时显示的下载文件名
        * */
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());

        //实现文件下载
        byte[] buffer = new byte[1024];
        //输入流
        FileInputStream fis = new FileInputStream(file);
        //输出流
        ServletOutputStream os = response.getOutputStream();
        int i = fis.read(buffer);
        while (i != -1){
            os.write(buffer, 0, i);
            i = fis.read(buffer);
        }
        //关闭流
        fis.close();
        os.flush();
        os.close();
    }

    /*
    * 上传 upload
    * */
    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, Object> upload(MultipartFile file)throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("/home/guan/cstudy/"+file.getOriginalFilename()));
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("status", "上传成功");
        return map;
    }

    /*
    * 空指针异常
    * */
    @RequestMapping("/null")
    public void nullPointException(MultipartFile file)throws IOException {
        String string = null;
        string.toString();
    }
    
}
