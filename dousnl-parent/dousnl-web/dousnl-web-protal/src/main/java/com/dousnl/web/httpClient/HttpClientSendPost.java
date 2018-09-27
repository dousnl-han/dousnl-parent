package com.dousnl.web.httpClient;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientSendPost {
	
	public static String send(String token,String openid,String url, Map<String,String> map,String encoding) throws ClientProtocolException, IOException{
		String result = "";
		String urlNameString = "https://api.weixin.qq.com/sns/userinfo?access_token=TOKEN&openid=OPENID";
	    urlNameString=urlNameString.replace("TOKEN", token);
	    urlNameString=urlNameString.replace("OPENID",openid);
		//创建HttpClient对象
		CloseableHttpClient clent=HttpClients.createDefault();
		//创建HttpPost对象
		HttpPost httpPost=new HttpPost(urlNameString);
		HttpEntity entity=new StringEntity("");
		httpPost.setEntity(entity);
		HttpResponse httpResponse = clent.execute(httpPost);
		//HttpEntity entity = httpResponse.getEntity();
		if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
			result = EntityUtils.toString(entity, "utf-8");
		}
		return result;
	}
	public static void main(String[] args) {
		//HttpClientSendPost.send(token, openid, url, map, encoding);
	}
}
