package com.yzh.ribbonrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author simple
 */
@Configuration
public class SelfRule {
    @Bean
    public IRule rule(){
        return new RandomRule(); // 自定义为随机
    }
}
