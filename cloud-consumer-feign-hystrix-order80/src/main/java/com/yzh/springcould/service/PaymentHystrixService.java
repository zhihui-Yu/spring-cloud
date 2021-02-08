package com.yzh.springcould.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author simple
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {
    @GetMapping("/{id}/ok")
    String ok(@PathVariable("id") String id);

    @GetMapping("/{id}/timeout")
    String timeout(@PathVariable("id") String id);
}
