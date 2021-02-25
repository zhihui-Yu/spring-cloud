package com.yzh.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yzh.springcloud.service.SimpleService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author simple
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalHandler")
public class SimpleController {
    private final Logger logger = LoggerFactory.getLogger(SimpleController.class);
    @Value("${server.port}")
    public String port;
    @Resource
    SimpleService simpleService;

    @GetMapping("/{id}/ok")
    public String ok(@PathVariable("id") String id) {
        logger.info("------ ok ------");
        return simpleService.ok(id);
    }

    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @GetMapping("/{id}/timeout")
    public String timeout(@PathVariable("id") String id) {
        logger.info("------ timeout ------");
        int i = 1 / 0;
        return simpleService.timeout(id);
    }

    public String timeoutHandler(@PathVariable("id") String id) {
        logger.info("------ timeout handler ------");
        return "timeout - handler";
    }

    // 以下是全局降级配置
    @GetMapping("/{id}/global")
    @HystrixCommand
    public String global(@PathVariable("id") String id) {
        logger.info("------ global ------");
        int i = 1/0;
        return simpleService.ok(id);
    }

    public String globalHandler() {
        logger.info("------ global handler ------");
        return "global - handler";
    }

    // === 熔断
    @HystrixCommand(fallbackMethod = "breakerHandler", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 是否开启熔断器
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),// 时间窗口期
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到多少后跳闸
    })
    @GetMapping("/{id}/circuit")
    public String circuitBreaker(@PathVariable("id") Integer id) {
        if (id< 0) throw new RuntimeException("id < 0");
        String uid = IdUtil.objectId();
        return Thread.currentThread().getName()+"\t"+" return id -> "+uid;
    }
    public String breakerHandler(@PathVariable("id") Integer id) {
        return "breaker_handler";
    }
}
