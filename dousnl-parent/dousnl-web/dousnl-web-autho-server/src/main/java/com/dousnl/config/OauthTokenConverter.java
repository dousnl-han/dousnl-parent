package com.dousnl.config;

import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.util.StringUtils;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/26 10:13
 */
//@Component
public class OauthTokenConverter extends JwtAccessTokenConverter {

    private final static String DCJM ="123";

    /**
     * 对称加密
     * @param key
     */
    @Override
    public void setSigningKey(String key) {
        if (StringUtils.isEmpty(key)){
            super.setSigningKey(DCJM);
        }
        super.setSigningKey(key);
    }

    /**
     * 认证服务2-非对称加密方式（公钥密钥）
     * @param keyPair
     */
    /*@Override
    public void setKeyPair(KeyPair keyPair) {
        KeyPair key=new KeyStoreKeyFactory(new ClassPathResource("mytest.jks"),"mypass".toCharArray())
                .getKeyPair("myalias");
        super.setKeyPair(key);
    }*/
}
