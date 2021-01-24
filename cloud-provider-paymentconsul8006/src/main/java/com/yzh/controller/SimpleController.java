package com.yzh.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author simple
 */
@Slf4j
@RestController
public class SimpleController {
    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/payment/consul")
    public String consul() {
        return "payment-consul-service: " + port + "\t" + UUID.randomUUID().toString();
    }
}
