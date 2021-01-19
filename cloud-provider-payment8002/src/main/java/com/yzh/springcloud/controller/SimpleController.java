package com.yzh.springcloud.controller;

import com.yzh.springcloud.entities.CommonResult;
import com.yzh.springcloud.entities.Payment;
import com.yzh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author simple
 */
@RestController
@Slf4j
public class SimpleController {
    private final Logger logger = LoggerFactory.getLogger(SimpleController.class);
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @PostMapping("/payment")
    public CommonResult create(@RequestBody Payment payment) {
        final int result = paymentService.create(payment);
        logger.info("-----" + result);

        if (result > 0) {
            return new CommonResult(200, "success", result);
        } else {
            return new CommonResult(500, "failed", null);
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        final Payment payment = paymentService.getPaymentById(id);
        logger.info("-----" + payment);

        if (payment != null) {
            return new CommonResult(200, "success for " + port, payment);
        } else {
            return new CommonResult(500, "failed", null);
        }
    }
}
