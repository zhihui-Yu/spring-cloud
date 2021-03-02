package com.yzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author simple
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain5544 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain5544.class, args);
    }
}
