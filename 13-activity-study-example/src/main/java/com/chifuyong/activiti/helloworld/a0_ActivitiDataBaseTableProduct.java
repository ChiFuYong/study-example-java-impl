package com.chifuyong.activiti.helloworld;

import org.activiti.engine.*;
import org.junit.Test;

/**
 * 测试 activiti 所需要的 25 张表的生成
 * @Date: 2020/9/6
 * @author: chify
 */
public class a0_ActivitiDataBaseTableProduct {

    @Test
    public void testGenTable(){
        //创建 ProcessEngine 对象，条件：1.activiti 配置文件名称：activiti.cfg.xml   2.bean 的 id="processEngineConfiguration"
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);

        /*
         * activiti 的资源管理类，提供了管理和控制流程发布包和流程定义的操作。
         * 使用工作流建模工具设计的业务流程图需要使用此 service 将流程定义文件的内容部署到计算机。
         */
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // activiti 的流程运行管理类。可以从这个服务类中获取很多关于流程执行相关的信息
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // activiti 的任务管理类。可以从这个类中获取任务的信息
        TaskService taskService = processEngine.getTaskService();

       /*
           activiti 的历史管理类，可以查询历史信息，执行流程时，引擎会保存很多数据（根据配置），比
           如流程实例启动时间，任务的参与者， 完成任务的时间，每个流程实例的执行路径，等等。 这个
           服务主要通过查询功能来获得这些数据。
       */
        HistoryService historyService = processEngine.getHistoryService();

        /*
           activiti 的引擎管理类，提供了对 Activiti 流程引擎的管理和维护功能，这些功能不在工作流驱动
           的应用程序中使用，主要用于 Activiti 系统的日常维护。
        */
        ManagementService managementService = processEngine.getManagementService();

    }


    @Test
    public void testGenTable2(){
        //1.创建ProcessEngineConfiguration对象  第一个参数:配置文件名称  第二个参数是 processEngineConfiguration 的 bean 的 id
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml","processEngineConfiguration");

        //也可以直接使用默认的 bean 默认名称：processEngineConfiguration
        ProcessEngineConfiguration configuration1 = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        //2.创建 ProcesEngine 对象
        ProcessEngine processEngine = configuration1.buildProcessEngine();
        //3.输出 processEngine 对象
        System.out.println(processEngine);
    }
}
