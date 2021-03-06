package com.yzh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simple
 */
@RestController
@RefreshScope
public class SimpleController {
    @Value("${server.port}")
    String port;
    @Value("${config.info}")
    String configInfo;

    @GetMapping("/info")
    public String getConfigInfo() {
        return port + "-" + configInfo;
    }
}
