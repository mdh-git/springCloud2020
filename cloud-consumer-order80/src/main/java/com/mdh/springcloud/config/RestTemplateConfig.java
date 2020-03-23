package com.mdh.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate的配置
 *
 * @author madonghao
 * @create 2020-03-23 9:28
 **/
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
