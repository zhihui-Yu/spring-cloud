package com.yzh.springcould.controller;

import com.yzh.springcould.service.PaymentHystrixService;
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
@Slf4j
@RestController
public class SimpleController {
    private final Logger logger = LoggerFactory.getLogger(SimpleController.class);
    @Value("${server.port}")
    String port;
    @Resource
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/{id}/ok")
    public String ok(@PathVariable("id") String id) {
        logger.info("------ ok ------");
        return "port:" + port + "\t" + paymentHystrixService.ok(id);
    }

    @GetMapping("/{id}/timeout")
    public String timeout(@PathVariable("id") String id) {
        logger.info("------ timeout ------");
        return "port:" + port + "\t" + paymentHystrixService.timeout(id);
    }
}
