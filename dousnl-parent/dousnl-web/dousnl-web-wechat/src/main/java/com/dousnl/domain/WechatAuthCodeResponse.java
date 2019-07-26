package com.dousnl.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>调用微信服务器-响应类:</p>
 * 
 * @author 韩亮亮
 * @date 2019年2月25日 上午11:36:59
 * @version 1.0
 */
@Getter
@Setter
@ToString
public class WechatAuthCodeResponse {

	private String openid;
	
	private String session_key;
	
	private Long expiresIn;
	
	private String errcode;
	
	private String errmsg;
}
