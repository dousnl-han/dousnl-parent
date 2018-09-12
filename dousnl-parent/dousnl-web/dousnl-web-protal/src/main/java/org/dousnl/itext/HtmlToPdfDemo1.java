package org.dousnl.itext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class HtmlToPdfDemo1 {

	/*  
     * HTML转换为PDF  
     *   
     */  
    public  void  HtmlToPdf(String inputFile,String outputFile) throws Exception{  
            String url = new File(inputFile).toURI().toURL().toString();  
            System.out.println(url);  
            OutputStream os = new FileOutputStream(outputFile);  
            ITextRenderer renderer = new ITextRenderer();  
            renderer.setDocument(url);  
            // 解决中文支持问题  
            ITextFontResolver fontResolver = renderer.getFontResolver();  
            // 解决图片的相对路径问题  
            // renderer.getSharedContext().setBaseURL("file:/D:/z/temp/");  
            renderer.layout();  
            renderer.createPDF(os);  
            os.close();  
          }
    
	public static void main(String[] args) throws Exception{
		HtmlToPdfDemo1 demo = new HtmlToPdfDemo1();  
        String inputFile = "E:/workspace/dousnl-parent/dousnl-web/dousnl-web-protal/src/main/webapp/WEB-INF/jsp/login.jsp";  
        String outputFile = "E://123.pdf";  
        demo.HtmlToPdf(inputFile, outputFile);  


	}

}
