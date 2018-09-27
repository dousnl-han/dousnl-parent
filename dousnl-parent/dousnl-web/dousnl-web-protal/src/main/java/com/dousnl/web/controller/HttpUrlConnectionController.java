package com.dousnl.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dousnl.web.util.DateUtils;

@Controller
@RequestMapping("/dousnl/httpUrl/")
public class HttpUrlConnectionController {

	@RequestMapping("client")
	@ResponseBody
	public String clientSend(HttpServletRequest request,HttpServletResponse response){
		String urlResource="http://127.0.0.1:8060/httpUrl/server";
		String json="{'username':'zhang','password':'1212323'}";
		OutputStream os=null;
		OutputStreamWriter osw=null;
		URL url=null;
		String responseResult="";
		try {
			url = new URL(urlResource);
			HttpURLConnection urlconnection=(HttpURLConnection) url.openConnection();
			urlconnection.setRequestProperty("Content-Type", "text/html");
			urlconnection.setDoOutput(true);
			urlconnection.setDoInput(true);
			urlconnection.setUseCaches(false);
			urlconnection.connect();
			os=urlconnection.getOutputStream();
			osw=new OutputStreamWriter(os);
			osw.write(json);
			osw.flush();
			osw.close();
			System.out.println("--------客户端发送请求  Start send ----------");
			System.out.println("send Ok !");
			System.out.println("--------客户端请求结束  End send ----------");
			int code=urlconnection.getResponseCode();
			System.out.println("--------客户端接收响应  Start receive ----------");
			System.out.println("code:"+code);
			System.out.println("ResponseMessage:"+urlconnection.getResponseMessage());
			
			//读取响应内容
			if(200==code){
				InputStream in=urlconnection.getInputStream();
				InputStreamReader is=new InputStreamReader(in);
				BufferedReader buffer=new BufferedReader(is);
				String readine="";
				while((readine=buffer.readLine())!=null){
					responseResult+=readine;
				}
			}else{
				responseResult="远程服务器请求异常，错误代码："+code;
			}
			System.out.println("responseResult:"+responseResult);
			JSONObject jsonObject=JSON.parseObject(responseResult);
			String state=jsonObject.getString("state");
			String date=jsonObject.getString("date");
			String successMessage=jsonObject.getString("successMessage");
			System.out.println("state:"+state+"\t date:"+date+"\t successMessage:"+successMessage);
			System.out.println("--------客户端响应结束  End receive ----------");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(os!=null){
				  os.close();
				}
				if(osw!=null){
				  osw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseResult;
		
	}
	@RequestMapping("server")
	public void serverSend(HttpServletRequest request,HttpServletResponse response){
		System.out.println("--------服务端接收请求  Start read ----------");
		InputStream in=null;
		InputStreamReader is=null;
		try {
			in=request.getInputStream();//获取请求输入流
			int size=request.getContentLength();//获取请求输入流长度
			is=new InputStreamReader(in);
			BufferedReader buffer=new BufferedReader(is);
			String result="";
			String readine="";
			while((readine=buffer.readLine())!=null){
				result+=readine;
			}
			System.out.println("server result:"+result);
			JSONObject jsonObject=JSON.parseObject(result);
			String username=jsonObject.getString("username");
			String password=jsonObject.getString("password");
			System.out.println("username:"+username+"\t password:"+password);
			response.setContentType("text/html");
			//注意响应中文数据时要设置
			response.setCharacterEncoding("GBK");
			PrintWriter write=response.getWriter();
			String recerivedate=DateUtils.dateToString(new Date(),null);
			//回应响应数据
			String str="{'state':'1','successMessage':'server receive success','date':\'"+recerivedate+"\'}";
			write.write(str);
			System.out.println("--------服务端请求结束  End read ----------");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(in!=null){
				    in.close();
				}
				if(is!=null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
