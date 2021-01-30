package com.yzh.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author simple
 */
@Component
public class FeignConfig {
    @Bean
    Logger.Level loggerLevel(){
        return Logger.Level.FULL;
    }
}
