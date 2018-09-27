package com.dousnl.web.httpClient;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

public class SimpleClient {

	/*public static void main(String[] args) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		try {
			HttpResponse httpResponse=httpclient.execute(httpGet);
			if(httpResponse.getStatusLine().getStatusCode()==200){
				System.out.println("httpResponse:"+httpResponse.getEntity());
			}	
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				httpclient.close();
			} catch (Exception e2) {
			}
		}
	}*/
}
