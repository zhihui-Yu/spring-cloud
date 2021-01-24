package com.yzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author simple
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZk80Main {
    public static void main(String[] args) {
        SpringApplication.run(OrderZk80Main.class, args);
    }
}
