package com.yzh.springcould.service;

import org.springframework.stereotype.Component;

/**
 * @author simple
 */
@Component
public class PaymentHystrixFallbackService implements PaymentHystrixService {
    @Override
    public String ok(String id) {
        return "PaymentHystrixFallbackService -- ok ";
    }

    @Override
    public String timeout(String id) {
        return "PaymentHystrixFallbackService -- timeout ";
    }
}
