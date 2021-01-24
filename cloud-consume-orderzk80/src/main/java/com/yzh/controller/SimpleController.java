package com.yzh.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author simple
 */
@RestController
@Slf4j
public class SimpleController {
    private static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Resource
    RestTemplate restTemplate;

    @RequestMapping(value = "/order/payment")
    public String paymentInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }
}
