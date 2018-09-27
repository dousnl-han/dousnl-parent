package com.dousnl.httpclient;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url="http://www.baidu.com";
		CloseableHttpClient createDefault = HttpClients.createDefault();
		HttpGet httpGet=new HttpGet(url);
		//设置超时时间
		Builder builder=RequestConfig.custom();
		builder.setConnectTimeout(10000);
		RequestConfig config = builder.build();
		httpGet.setConfig(config);
		//发送请求
		HttpResponse httpResponse = createDefault.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println("result:"+string);
	}

}
