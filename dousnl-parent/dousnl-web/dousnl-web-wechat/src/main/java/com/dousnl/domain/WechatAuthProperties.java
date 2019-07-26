package com.dousnl.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>微信登录配置文件类:</p>
 * 
 * @author 韩亮亮
 * @date 2019年2月25日 上午11:08:47
 * @version 1.0
 */
@Component
@Getter
@Setter
@ToString
public class WechatAuthProperties {

	@Value("${auth.wechat.sessionHost}")
    private String sessionHost;

    @Value("${auth.wechat.appId}")
    private String appId;

    @Value("${auth.wechat.secret}")
    private String secret;

    @Value("${auth.wechat.grantType}")
    private String grantType;
    
}
