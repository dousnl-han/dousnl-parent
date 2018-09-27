package com.dousnl.web.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.tidy.Configuration;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.dousnl.annotation.Log;
import com.dousnl.util.DCUtil;

@Controller
@RequestMapping("/pdf/")
public class PdfController {

	@RequestMapping("itext")
	@Log(name="itext",value="itextPDF")
	public String itext(){
		System.out.println("==================itext=====================");
		return "itext";
	}
	
	@RequestMapping(value="downLoadPdf")
	public void downLoadPdf(HttpServletRequest request ,HttpServletResponse res,Principal principal,String contractId) throws Exception{
		 OutputStream os = res.getOutputStream();  
		    try {  
		    	contractId=DCUtil.genQTCodeID();
		    	String pdfName =  contractId +".pdf";
 		    	String urlString = new StringBuilder().append("http://127.0.0.1:8060/itext").toString();
		    	res.reset();  
		        res.setHeader("Content-Disposition", "attachment; filename=\""+new String(pdfName.getBytes("gbk"),"iso-8859-1") + "\"");  
		        res.setContentType("application/octet-stream; charset=utf-8");  
 			    exportPDF(urlString,os) ;
			    os.flush();  
		 	 	   
		    }catch(Exception e){
		    	e.printStackTrace();
		    } finally {  
		        if (os != null) {  
		            os.close();  
		        }  
		    }   
	}
	
	@RequestMapping(value="downLoadPdfByString")
	public void downLoadPdfByString(HttpServletRequest request ,HttpServletResponse res,Principal principal,String contractId) throws Exception{
		 OutputStream os = res.getOutputStream();  
		    try {  
		    	contractId=DCUtil.genQTCodeID();
		    	String pdfName =  contractId +".pdf";
		    	res.reset();  
		        res.setHeader("Content-Disposition", "attachment; filename=\""+new String(pdfName.getBytes("gbk"),"iso-8859-1") + "\"");  
		        res.setContentType("application/octet-stream; charset=utf-8");  
		        exportPDFByString(os) ;
			    os.flush();  
		    }catch(Exception e){
		    	e.printStackTrace();
		    } finally {  
		        if (os != null) {  
		            os.close();  
		        }  
		    }   
	}
	private void exportPDF(String urlString,OutputStream os) throws Exception{
		 URL  url = new URL(urlString);  
		 HttpURLConnection uc = (HttpURLConnection)url.openConnection();  
		 uc.setRequestProperty("Content-Type", "plain/text; charset=UTF-8");  
        System.out.println(uc.getResponseCode());
         InputStream is = uc.getInputStream(); 
        Tidy tidy = new Tidy();  
        OutputStream os2 = new ByteArrayOutputStream();  
        tidy.setXHTML(true); // 设定输出为xhtml(还可以输出为xml)  
        tidy.setCharEncoding(Configuration.UTF8); // 设定编码以正常转换中文  
        tidy.setTidyMark(false); // 是否生成tidy标记，，不设置它会在输出的文件中给加条meta信息  
        tidy.setXmlPi(true); // 文件头输出xml标记，，让它加上<?xml version="1.0"?>  
        tidy.setIndentContent(true); // 缩进，可以省略，只是让格式看起来漂亮一些  
        tidy.parse(is, os2);  
        is.close();  
        // 解决乱码 --将转换后的输出流重新读取改变编码  
        String temp;  
        StringBuffer sb = new StringBuffer();  
        BufferedReader in = new BufferedReader(new InputStreamReader(  
                new ByteArrayInputStream(  
                        ((ByteArrayOutputStream) os2).toByteArray()),  
                "utf-8"));  
        while ((temp = in.readLine()) != null) {  
            sb.append(temp);  
        }  
        System.out.println("tidy-parse-string==>>"+sb.toString());
       try{
         org.xhtmlrenderer.pdf.ITextRenderer renderer = new ITextRenderer();  
         renderer.setDocumentFromString(sb.toString());  
            renderer.layout();  
  
            renderer.createPDF(os);  
            renderer.finishPDF();
            os.flush();  
        }catch(Exception e){
       	 e.printStackTrace();
        }finally{
            os2.close();
        }  
	}
	private void exportPDFByString(OutputStream os) throws Exception{
		String urlString = new StringBuilder().append("http://127.0.0.1:8060/itext").toString();
       String url="http://www.baidu.com";
		HttpClient client=new DefaultHttpClient();
		HttpGet httpGet=new HttpGet(urlString);
		HttpResponse httpResponse = client.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		byte[] byteArray = EntityUtils.toByteArray(entity);
		String result=new String(byteArray);
		System.out.println("result:"+result);
      try{
        org.xhtmlrenderer.pdf.ITextRenderer renderer = new ITextRenderer();  
        renderer.setDocumentFromString(result);  
           renderer.layout();  
 
           renderer.createPDF(os);  
           renderer.finishPDF();
           os.flush();  
       }catch(Exception e){
      	 e.printStackTrace();
       }finally{
           os.close();
       }  
	}
}
