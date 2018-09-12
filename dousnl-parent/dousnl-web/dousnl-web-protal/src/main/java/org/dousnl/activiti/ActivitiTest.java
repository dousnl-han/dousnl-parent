/*package org.dousnl.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActivitiTest {
   
	public static void main(String[] args) {
		 
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-mybatis.xml");
        ProcessEngine processEngine= (ProcessEngine) context.getBean("processEngine");

        //部署流程
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment =repositoryService.createDeployment().addClasspathResource("studentAskOffProcess2.bpmn").deploy();

        //启动流程 启动流程使用流程定义中的 processid="studentAskOffProcess"
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance =runtimeService.startProcessInstanceByKey("studentAskOffProcess");

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