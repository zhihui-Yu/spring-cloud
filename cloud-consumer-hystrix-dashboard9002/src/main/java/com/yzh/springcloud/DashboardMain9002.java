package com.yzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author simple
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(DashboardMain9002.class,args);
    }
}
