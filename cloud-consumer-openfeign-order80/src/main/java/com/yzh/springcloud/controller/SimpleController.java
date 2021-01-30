package com.yzh.springcloud.controller;

import com.yzh.springcloud.entities.CommonResult;
import com.yzh.springcloud.entities.Payment;
import com.yzh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
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
    @Value("${server.port}")
    String port;
    @Resource
    PaymentService paymentService;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        return paymentService.get(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String timeout() {
        return paymentService.timeout();
    }
}
