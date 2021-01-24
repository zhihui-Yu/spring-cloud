package com.yzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author simple
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsul8006Main {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsul8006Main.class, args);
    }
}
