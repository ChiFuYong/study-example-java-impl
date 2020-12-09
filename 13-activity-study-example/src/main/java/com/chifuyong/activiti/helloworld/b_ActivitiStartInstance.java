package com.chifuyong.activiti.helloworld;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

/**
 * 启动流程实例:
 *     前提是先已经完成流程定义的部署工作
 *     背后影响的表：
 *       act_hi_actinst     已完成的活动信息
         act_hi_identitylink   参与者信息
         act_hi_procinst   流程实例
         act_hi_taskinst   任务实例
         act_ru_execution   执行表
         act_ru_identitylink   参与者信息
         act_ru_task  任务
 *
 *  @Date: 2020/9/6
 * @author: chify
 */
public class b_ActivitiStartInstance {

    /**
     * 不设置 businessKey 启动流程
     * */
    @Test
    public void startNewProcess(){
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RunService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3.创建流程实例  流程定义的key需要知道 holiday
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday");
        //4.输出实例的相关信息，由输出可知，每次启动的流程实例，都是从最新的部署的流程图模版中生成的
        System.out.println("流程部署ID：" + processInstance.getDeploymentId());//null
        System.out.println("流程定义ID：" + processInstance.getProcessDefinitionId());//holiday:1:4
        System.out.println("流程实例ID：" + processInstance.getId());//2501
        System.out.println("活动ID：" + processInstance.getActivityId());//null
    }

    /**
     * 设置 businessKey 启动流程
     * 本质：act_ru_execution 表中的 businessKey 的字段会存入 businessKey
     * */
    @Test
    public void startNewProcessAndKey(){
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3.启动流程实例,同时还要指定业务标识 businessKey,它本身就是请假单的id
        //第一个参数：是指流程定义 key ；第二个参数：业务标识 businessKey
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday", "1001");
        //4.输出 processInstance 相关的属性,取出 businessKey 使用: processInstance.getBusinessKey()
        System.out.println(processInstance.getBusinessKey());

    }
}
