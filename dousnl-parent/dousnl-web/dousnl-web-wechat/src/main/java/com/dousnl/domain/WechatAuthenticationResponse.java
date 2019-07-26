package com.dousnl.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>调用微信服务器-响应类: </p>
 * 
 * @author 韩亮亮
 * @date 2019年2月25日 下午5:59:41
 * @version 1.0
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
public class WechatAuthenticationResponse {

	private String openid;

	private String session_key;

	private String skey;
	
	private Long expiresIn;
}
