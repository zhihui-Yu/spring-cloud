package com.yzh.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simple
 */
@RestController
public class ZipkinController {
    @GetMapping("/zipkin")
    public String zipkin() {
        return "zipkin call back";
    }
}
