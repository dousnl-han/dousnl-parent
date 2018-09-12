/*package org.dousnl.activiti.controller;


import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


*//**
 * @ClassName: ActivitiController
 * @Description: TODO()
 * @author han
 * @date 2016年11月2日
 *//*
@Controller
@RequestMapping("/activiti/")
public class ActivitiController {

    @Autowired  
    protected RuntimeService runtimeService2;
    
	@RequestMapping("start")
	public void StartProcess(String processKey){
		//启动流程 启动流程使用流程定义中的 processid="studentAskOffProcess"
		//RuntimeService runtimeService2 = process.getRuntimeService();
        ProcessEngineConfigurationImpl processEngineConfiguration = process.getProcessEngineConfiguration();
        RuntimeService runtimeService =processEngineConfiguration.getRuntimeService();
		Map<String, Object> variables = new HashMap<>();
        variables.put("applicantName", "John Doe");
        variables.put("email", "john.doe@activiti.com");
        variables.put("phoneNumber", "123456789");
        ProcessInstance processInstance =runtimeService2.startProcessInstanceByKey("process_dousnl_check",variables);

        //取得任务接口
        TaskService taskService = processEngine.getTaskService();
        //查询流转到accountancy 的任务
        List<Task>tasks =taskService.createTaskQuery().taskCandidateUser("fuxs").list();
        Task task = null;

        System.out.println("tasks.size()= " + tasks.size());
        for (int i = 0; i< tasks.size(); i++) {
                 task =tasks.get(i);
                 System.out.println("task= " + task.getId() + "-" + task.getName());
        }

        //完成任务
        taskService.complete(task.getId());

        tasks =taskService.createTaskQuery().taskCandidateUser("admin").list();
        System.out.println("tasks.size()= " + tasks.size());
        for (int i = 0; i< tasks.size(); i++) {
                 task =tasks.get(i);
                 System.out.println("task= " + task.getId() + "-" + task.getName());
        }
	}
	
}
*/