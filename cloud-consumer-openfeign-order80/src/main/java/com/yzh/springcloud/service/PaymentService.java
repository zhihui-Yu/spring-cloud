package com.yzh.springcloud.service;

import com.yzh.springcloud.entities.CommonResult;
import com.yzh.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author simple
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @GetMapping("/payment/{id}")
    CommonResult<Payment> get(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    String timeout();
}
