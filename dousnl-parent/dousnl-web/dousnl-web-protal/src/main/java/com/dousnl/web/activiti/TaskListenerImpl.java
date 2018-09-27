package com.dousnl.web.activiti;
/*package com.dousnl.web.activiti;

import java.util.List;
import java.util.Map;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;


public class TaskListenerImpl implements TaskListener{

	public void notify(DelegateTask arg0) {
		// TODO Auto-generated method stub
		
	}

	*//**����ָ������İ�����*//*
	public void notify(DelegateTask delegateTask) {
		//�������ĸ�������1�Ļ�����IDΪRoleID
        String sql = "select * From tb_relation where intershipid='" + processDefId + "' and childCode='" + lastassignee + "'";

        Dbhelper dbCourseCurrentadd = new Dbhelper();
         dbCourseCurrentadd.setSql(sql.toString());      
         List<Map<String,Object>> listmap =  dbCourseCurrentadd.findItemById();

         if(listmap.size() > 0 && listmap!=null){
             Map<String, Object> m = listmap.get(0);    
             nextLevel = (String) m.get("fatherCode");
         }
	}

}
*/