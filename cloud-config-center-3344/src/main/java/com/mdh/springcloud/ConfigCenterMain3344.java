package com.mdh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 设置hosts 参数 127.0.0.1  config-3344.com
 * http://config-3344.com:3344/application-dev.yml
 * http://config-3344.com:3344/application-test.yml
 *
 * @author madonghao
 * @create 2020-04-20 15:53
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
