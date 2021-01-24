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
    private static final String PAYMENT_URL = "http://cloud-provider-paymentconsul8006";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/order/payment/consul")
    public String consul() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }
}
