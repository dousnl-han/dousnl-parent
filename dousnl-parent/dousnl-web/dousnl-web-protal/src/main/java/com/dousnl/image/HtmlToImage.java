package com.dousnl.image;

import java.io.File;
import java.io.FileOutputStream;

import org.fit.cssbox.demo.ImageRenderer;


public class HtmlToImage {

	public static void main(String[] args) throws Exception {
	       ImageRenderer render = new ImageRenderer();
	       String url ="https://zhidao.baidu.com/question/684151522432458492.html";
	       FileOutputStream out = new FileOutputStream(new File("E:"+File.separator+"xxxhtml.png"));
	       render.renderURL(url, out, ImageRenderer.Type.PNG);
	    }
}
