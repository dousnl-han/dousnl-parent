package com.dousnl.web.httpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author hanliang
 * 使用HttpClient发送和接收JSON请求
 */
public class HttpClientJson {

	/**
	 * @description post请求
	 * @author hanliang
	 * @version 1.0
	 * @parameter @param url
	 * @parameter @param json
	 * @parameter @return 
	 */
	public static JSONObject dopost(String url,JSONObject json){
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpPost httpPost=new HttpPost(url);
		JSONObject response=null;
		try {
			StringEntity s=new StringEntity(json.toString());
			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");//发送json数据需要设置contentType
			httpPost.setEntity(s);
			HttpResponse httpResponse=httpClient.execute(httpPost);
			if(200==(httpResponse.getStatusLine().getStatusCode())){
				String result=EntityUtils.toString(httpResponse.getEntity(), "utf-8");//返回json格式：
				response=JSONObject.parseObject(result);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return json;	
	}
}
