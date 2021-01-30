package com.yzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author simple
 */
@EnableFeignClients
@SpringBootApplication
public class OrderFeign80Main {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeign80Main.class,args);
    }
}
