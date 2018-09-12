package org.dousnl.web.test;

import java.util.List;
import java.util.Map;

import org.dousnl.api.domain.User;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonConver {

	public static void main(String[] args) {
		String jsontx="{\"name\":\"����\",\"age\":\"21\"}";
		String jsonList="[{\"name\":\"����\",\"age\":\"21\"},{\"name\":\"����\",\"age\":\"22\"}]";
		String jsonstr="{js:[{\"name\":\"����\",\"age\":\"21\"},{\"name\":\"����\",\"age\":\"22\"}"
		              +",{name:\"����\",\"age\":\"23\"},{name:\"����\",\"age\":\"25\"}]}";
		JSONObject jsonObject=JSONObject.parseObject(jsontx);
		System.out.println("������"+jsonObject.get("name"));
		System.out.println("���䣺"+jsonObject.get("age"));
		User jsonBean=JSONObject.parseObject(jsontx, User.class);
		System.out.println("������"+jsonBean.getName());
		System.out.println("���䣺"+jsonBean.getAge());
		List<User> userlist=JSONObject.parseArray(jsonList, User.class);
		for(User u:userlist){
			System.out.println("������"+u.getName());
			System.out.println("���䣺"+u.getAge());
		}
		JSONObject str=JSONObject.parseObject(jsonstr);
		Object obj=str.get("js");
		System.out.println("obj��"+obj);
		List<Map<String,Object>> userlist2=(List<Map<String, Object>>) JSON.parse(obj+"");
		List<Object> userlist3=(List<Object>) JSON.parse(obj+"");
		List<User> userlist4=(List<User>) JSON.parse(obj+"");
		System.out.println("map:"+userlist2);
		System.out.println("object:"+userlist3);
		System.out.println("user:"+userlist4);
		//List<User> userlist2=JSONObject.parseArray(obj+"", User.class);
		/*for(User u:userlist2){
			System.out.println("������"+u.getName()+"  "+"����:"+u.getAge());
			JSONObject jsonobj=(JSONObject) JSONObject.toJSON(u);
			System.out.println("json:"+jsonobj+" "+"������"+jsonobj.get("name"));
		}*/
	}
}
