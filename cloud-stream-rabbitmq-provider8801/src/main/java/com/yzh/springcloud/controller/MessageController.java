package com.yzh.springcloud.controller;

import com.yzh.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author simple
 */
@RestController
public class MessageController {
    @Resource
    IMessageProvider messageProvider;

    @GetMapping("/send")
    public String send() {
        return messageProvider.send();
    }
}
