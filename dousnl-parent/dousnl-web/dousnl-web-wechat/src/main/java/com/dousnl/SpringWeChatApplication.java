package com.dousnl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 微信服务
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/24 16:01
 */
@EnableAutoConfiguration
@SpringBootApplication
public class SpringWeChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWeChatApplication.class,args);
    }
}
