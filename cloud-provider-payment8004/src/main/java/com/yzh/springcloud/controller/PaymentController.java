package com.yzh.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author simple
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/payment/zk")
    public String payment() {
        return "string-cloud with zookeeper: " + port + "\t" + UUID.randomUUID().toString();
    }
}
