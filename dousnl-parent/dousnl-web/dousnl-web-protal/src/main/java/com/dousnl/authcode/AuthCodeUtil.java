package com.dousnl.authcode;

import java.util.Properties;

import javax.imageio.ImageIO;
import javax.servlet.jsp.jstl.core.Config;

public class AuthCodeUtil {

	//private Producer kaptchaProducer;
	
	
	public void init(){
		Properties props=new Properties();
		props.put("kaptcha.textproducer.char.string", "123456789"); //文本集合
		//props.put("kaptcha.textproducer.impl", "com.google.code.kaptcha.text.impl.ChineseTextProducer");
		props.put("kaptcha.textproducer.char.length", "4");//四个字符
		props.put("kaptcha.textproducer.char.space", "5"); //文字间隔
		props.put("kaptcha.border", "no"); //图片边框
		props.put("kaptcha.textproducer.font.size", "30"); //字体大小
		props.put("kaptcha.textproducer.font.names", "宋体"); //字体Arial、Courier
		props.put("kaptcha.textproducer.font.color", "6,7,150");//字体颜色
		props.put("kaptcha.image.width", "112"); //图片宽
		props.put("kaptcha.image.height", "36"); //图片高
		props.put("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise"); //干扰实现类 
		props.put("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy"); //(阴影效果)
		props.put("kaptcha.background.clear.from", "white");
		props.put("kaptcha.background.clear.to", "white");
		ImageIO.setUseCache(false);
		Config config=new Config();
	}
}
