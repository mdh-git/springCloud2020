package com.mdh.caffeinedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Caffeine 缓存
 */
@EnableCaching
@SpringBootApplication
public class CaffeineDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaffeineDemoApplication.class, args);
    }

}
