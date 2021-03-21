package com.yzh.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simple
 */
@RestController
@RefreshScope
@Slf4j
public class SimpleController {
    @Value("${config.info}")
    String value;

    @GetMapping(value = "/config/info")
    public String info() {
        return value;
    }
}
