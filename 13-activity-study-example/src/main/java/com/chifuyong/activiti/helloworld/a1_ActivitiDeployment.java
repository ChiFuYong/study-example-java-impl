package com.chifuyong.activiti.helloworld;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * 流程定义部署测试
 * activiti表有哪些？
 *   act_re_deployment  部署信息
     act_re_procdef     流程定义的一些信息
     act_ge_bytearray   流程定义的bpmn文件及png文件
 *
 * @Date: 2020/9/3
 * @author: chify
 */
public class a1_ActivitiDeployment {

    /**
     * 流程定义部署  流程制作出来后要上传到服务器 zip 文件更便于上传
     * 注：.zip 文件中需要有 .bpmn 和 .png 文件
     */
    @Test
    public void zipDeployment() {
        //1.创建 ProcessEngine 对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到 RepositoryService 实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.转化出 ZipInputStream 流对象
        InputStream is = a1_ActivitiDeployment.class.getClassLoader().getResourceAsStream("diagram/01/holidayBPMN.zip");
        //将 InputStream 流转化为 ZipInputStream 流
        ZipInputStream zipInputStream = new ZipInputStream(is);
        //3.进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name("请假申请单流程")
                .deploy();
        //4.输出部署的一些信息
        System.out.println("流程部署名称：" + deployment.getName());
        System.out.println("流程部署id：" + deployment.getId());
    }

    /**
     * 流程定义部署
     */
    @Test
    public void commonDeployment(){
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.进行部署
        Deployment deployment = repositoryService.createDeployment()
                //添加 bpmn 资源
                .addClasspathResource("diagram/01/holiday.bpmn")
                //添加 png 图片
                .addClasspathResource("diagram/01/holiday.png")
                .name("请假申请单流程")
                .deploy();
        //4.输出部署的一些信息
        System.out.println("流程部署名称：" + deployment.getName());
        System.out.println("流程部署id：" + deployment.getId());
    }
}
