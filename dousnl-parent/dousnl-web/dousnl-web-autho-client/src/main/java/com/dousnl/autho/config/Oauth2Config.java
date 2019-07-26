package com.dousnl.autho.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;


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

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //*endpoints.reuseRefreshTokens(true);//重新计算刷新token
        endpoints.authenticationManager(authenticationManager);
                //.tokenStore(tokenStore());

        // 配置TokenServices参数
        /*DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setSupportRefreshToken(false);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        tokenServices.setAccessTokenValiditySeconds( (int) TimeUnit.MINUTES.toSeconds(10)); //分钟
        endpoints.tokenServices(tokenServices);*/

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //super.configure(clients);
        clients.inMemory() // 使用in-memory存储
                .withClient("clientapp") // client_id
                .redirectUris("http://localhost:8090/hello")
                .secret("112233") // client_secret
                //授权码模式
                //http://localhost:8080/oauth/authorize?client_id=clientapp&redirect_uri=http://www.baidu.com&response_type=code&scope=read_userinfo
                //http://localhost:8080/api/userinfo?access_token=9c686703-6bb5-4561-b1bb-528cf71861e8
                //简化模式
                //http://localhost:8080/oauth/authorize?client_id=clientapp&redirect_uri=http://www.baidu.com&response_type=token&scope=read_userinfo&state=abc
                //密码模式
                //http://localhost:8080/oauth/token?password=123&grant_type=password&username=dousnl&scope=read_userinfo
                //刷新模式
                //http://localhost:8080/oauth/authorize?client_id=clientapp&redirect_uri=http://www.baidu.com&response_type=code&scope=read_userinfo
                //http://localhost:8080/oauth/token?grant_type=refresh_token&refresh_token=ad3941d1-c6dd-4a2e-a9c8-eac6a9a59dd2
                /*{
                    "access_token": "b5178c2f-826e-4739-b0d4-6982f1c7075f",
                        "token_type": "bearer",
                        "refresh_token": "4ad34168-0200-42e5-bc36-59af4b88c623",
                        "expires_in": 43199,
                        "scope": "read_userinfo"
                }*/
                //.authorizedGrantTypes("authorization_code") // 授权码模式
                //.authorizedGrantTypes("implicit") //简化模式
                //.authorizedGrantTypes("password")  //密码模式
                .authorizedGrantTypes("authorization_code","refresh_token")  //刷新token模式
                .scopes("read_userinfo", "read_contacts"); // 允许的授权范围

    }
}
