package com.yzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author simple
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClient5522 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient5522.class, args);
    }
}
