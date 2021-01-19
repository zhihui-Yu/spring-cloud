package com.yzh.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author simple
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced // Ribbon 负载均衡策略
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
