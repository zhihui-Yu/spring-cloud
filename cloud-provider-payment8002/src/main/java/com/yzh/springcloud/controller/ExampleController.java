package com.yzh.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simple
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class ExampleController {
    @Value("${server.port}")
    String port;

    @GetMapping("/get/{id}")
    public String get(@PathVariable("id") String id) {
        return id + "---" + port;
    }

    @GetMapping("/lb/{id}")
    public String lb(@PathVariable("id") String id) {
        return id + "---" + port;
    }
}
