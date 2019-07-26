package com.dousnl.service.impl;

import com.alibaba.fastjson.JSON;
import com.dousnl.domain.WechatAuthCodeResponse;
import com.dousnl.domain.WechatAuthProperties;
import com.dousnl.service.WeChatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/24 17:25
 */
@Slf4j
@Service
public class WeChatServiceImpl implements WeChatService {

    private RestTemplate wxAuthRestTemplate = new RestTemplate();

    /**
     * 服务器第三方session有效时间，单位秒, 默认1天
     */
    private static final Long EXPIRES = 86400L;

    @Autowired
    private WechatAuthProperties wechatAuthProperties;


    @Override
    public String wechatLogin(String code) {
        log.info(">>>>>>>微信登录前端 code :{}", code);
        log.info(">>>>>>>start get SessionKey");
        WechatAuthCodeResponse response = getWxSession(code);
        return JSON.toJSONString(response);
    }

    public WechatAuthCodeResponse getWxSession(String code) {
        String urlString = "?appid={appid}&secret={srcret}&js_code={code}&grant_type={grantType}";
        String response = wxAuthRestTemplate.getForObject(wechatAuthProperties.getSessionHost() + urlString,
                String.class, wechatAuthProperties.getAppId(), wechatAuthProperties.getSecret(), code,
                wechatAuthProperties.getGrantType());
        log.info(">>>>>>>微信服务器响应 wechat response:{}", response);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader reader = objectMapper.readerFor(WechatAuthCodeResponse.class);
        WechatAuthCodeResponse res;
        try {
            res = reader.readValue(response);
        } catch (IOException e) {
            res = null;
            log.error("反序列化失败", e);
        }
        if (null == res) {
            throw new RuntimeException("调用微信接口失败");
        }
        if (res.getErrcode() != null) {
            throw new RuntimeException(res.getErrmsg());
        }
        res.setExpiresIn(res.getExpiresIn() != null ? res.getExpiresIn() : EXPIRES);
        return res;
    }
}
