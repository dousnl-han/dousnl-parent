package com.dousnl.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhuling
 * @since 2016/6/12
 * @description 获取验证码
 */
@Controller
public class CheckCodeController {
	private int width = 90 ;//定义图片的width
	private int height= 19 ;//定义图片的height
	private int codeCount = 4 ;//定义图片上显示验证码个数
	private int xx =15 ;
	private int fontHeight = 18 ;
	private int codeY = 16 ;
	char[] codeSequence = {
			'0','1','2','3','4','5','6','7','8','9'
	};
	@RequestMapping("/getCheckCode")
	public void getCheckCode(HttpServletRequest request,HttpServletResponse response)
		throws IOException{
		//定义图像buffer
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics gd = buffImg.getGraphics();
		//创建一个随机数生成器类
		Random random = new Random();
		//将图像填充成白色
		gd.setColor(Color.WHITE);
		gd.fillRect(0, 0, width, height);
		
		//创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
		//设置字体
		gd.setFont(font);
		
		//画边框
		gd.setColor(Color.BLACK);
		gd.drawRect(0, 0, width - 1, height - 1);	
		
		//randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();
		int red = 0,green = 0, blue = 0;
		
		//随机产生codeCount数字的验证码。
		for(int i =0 ; i<codeCount ; i++){
			//得到随机产生的验证码数字。
			String ChekCode = String.valueOf(codeSequence[random.nextInt(10)]);
			//产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
			red = 0;
			green = 0;
			blue = 0;
			
			//用随机产生的颜色将验证码绘制到图像中去
			gd.setColor(new Color(red, green, blue));
			gd.drawString(ChekCode, (i +1) * xx, codeY);
			
			//将产生的四个随机数组合到一起
			randomCode.append(ChekCode);
		}
		//将四位数字的验证码保存到Session中
		HttpSession session = request.getSession();
		session.setAttribute("checkCode", randomCode.toString());
		
		//禁止图像缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);	    
		response.setContentType("image/jpeg");
	    
	    //将图片输出到Servlet输出旅中
	    ServletOutputStream sos = response.getOutputStream();
	    ImageIO.write(buffImg, "jpeg", sos);
	    sos.close();	    
	}
}
