package com.dousnl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/29 9:27
 */
//@Configuration
//@EnableAuthorizationServer
public class Oauth2JwtServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;
    //@Autowired
    //private OauthTokenConverter oauthTokenConverter;
    //@Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("test-secret");
        return converter;
    }
    @Bean
    public JwtTokenStore tokenStore(){
        return new JwtTokenStore(accessTokenConverter());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //*endpoints.reuseRefreshTokens(true);//重新计算刷新token
        endpoints.authenticationManager(authenticationManager)
                 .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //super.configure(clients);
        clients.inMemory() // 使用in-memory存储
                .withClient("clientapp") // client_id
                .redirectUris("http://localhost:9000/callback")
                .secret("112233") // client_secret
                .authorizedGrantTypes("password","authorization_code","refresh_token")  //刷新token模式
                .scopes("read_userinfo", "read_contacts"); // 允许的授权范围

    }
}
