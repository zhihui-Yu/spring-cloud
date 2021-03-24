package com.yzh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yzh.springcloud.handler.ErrorHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simple
 */
@RestController
public class RateLimitController {
    @GetMapping(value = "/handler1")
    @SentinelResource(value = "handler1", blockHandlerClass = ErrorHandler.class, blockHandler = "handler1")
    public String handle1() {
        return "call success handler1";
    }

    @GetMapping(value = "/handler2")
    @SentinelResource(value = "handler2", blockHandlerClass = ErrorHandler.class, blockHandler = "handler2")
    public String handle2() {
        return "call success handler2";
    }
}
