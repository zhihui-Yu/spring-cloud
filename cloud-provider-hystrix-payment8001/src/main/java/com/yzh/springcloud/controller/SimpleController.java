package com.yzh.springcloud.controller;

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
}
