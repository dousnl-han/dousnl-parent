package com.dousnl.web.httpClient;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.alibaba.fastjson.JSONObject;

public class HttpClientDemo {

	public static void main(String[] args) {
		String formNo = "TR123456";
        HashMap<String, Object> notifyInfo = new HashMap<String, Object>();
        String time = String.valueOf(System.currentTimeMillis());
        String asz_access_key = "xxx";
        String content = formNo+time+asz_access_key;
        try {
            String sign = getBASE64Encoder(content);
            notifyInfo.put("referenceNo", formNo);
            notifyInfo.put("time", time);
            notifyInfo.put("sign", sign);
            } catch (Exception e) 
          {
              e.printStackTrace();
          } 
      //本地启动tomcat，调用本地tomcat接受数据
      boolean resultJSON = postJson("http://localhost:8080/testServlet1/MyFirstServlet", notifyInfo);
      System.out.println(resultJSON);

  }
	/**
     * sign加密
     * @return
     * @throws NoSuchAlgorithmException 
     * @throws UnsupportedEncodingException 
     */
    private static String  getBASE64Encoder(String content) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(content.getBytes("UTF-8"));
        //BASE64Encoder base64Encoder = new BASE64Encoder();
        //return base64Encoder.encode(bytes);
		return content;
    }
    /**
     * 以post方式调用httpClient
     * @param uri
     * @param param
     * @return
     */
    public static boolean postJson(String uri, HashMap<String, Object> param) {
        try {  
            CloseableHttpClient httpclient = HttpClients.createDefault();  
            HttpPost httpPost = new HttpPost(uri);   
            //添加http头信息  
            httpPost.addHeader("Content-Type", "application/json");  
            //设置字符集utf-8
            httpPost.getParams().setParameter( "http.protocol.content-charset","utf-8");
            //把数据改为String格式
            String stringObj = JSONObject.toJSONString(param);
            //封装数据
            httpPost.setEntity(new StringEntity(stringObj));     
            //执行调用，返回response
            CloseableHttpResponse response  = httpclient.execute(httpPost);  
            //检验状态码，如果成功接收数据  
            int code = response.getStatusLine().getStatusCode();  
            if (code == 200) {
                return true;
            } 
            }  catch (Exception e) { 
            }
            return false;  
    }
}
