package com.dousnl.util;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/11/7 16:44
 */
@Configuration
public class EsConfig {

    @Bean
    public RestHighLevelClient client(){
        RestHighLevelClient client=new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1",9200,"http"),
                        new HttpHost("127.0.0.1",9200,"http")
                )
        );
        return client;
    }


}
