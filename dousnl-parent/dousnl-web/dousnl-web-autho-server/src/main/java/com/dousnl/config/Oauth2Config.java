package com.dousnl.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;


/**
 * Oauth 授权服务
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/26 9:28
 */
@Configuration
@EnableAuthorizationServer
public class Oauth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    //@Autowired
    //private OauthTokenConverter oauthTokenConverter;

    /*@Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(oauthTokenConverter);
    }*/
    /*@Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        *//*endpoints.reuseRefreshTokens(true);//重新计算刷新token
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore());

        // 配置TokenServices参数
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setSupportRefreshToken(false);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        tokenServices.setAccessTokenValiditySeconds( (int) TimeUnit.MINUTES.toSeconds(10)); //分钟
        endpoints.tokenServices(tokenServices);*//*

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }*/

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //super.configure(clients);
        clients.inMemory() // 使用in-memory存储
                .withClient("client") // client_id
                .redirectUris("http://www.baidu.com")
                .secret("secret") // client_secret
                .authorizedGrantTypes("authorization_code") // 该client允许的授权类型
                .scopes("app"); // 允许的授权范围

    }
}
