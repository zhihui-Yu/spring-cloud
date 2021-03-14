package com.yzh.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author simple
 */
@RestController
public class ZipkinController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/zipkin")
    public String zipkin() {
        return restTemplate.getForObject(  "http://localhost:8001/zipkin", String.class);
    }
}
