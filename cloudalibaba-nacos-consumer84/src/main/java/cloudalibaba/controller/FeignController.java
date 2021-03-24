package cloudalibaba.controller;

import cloudalibaba.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author simple
 */
@RestController
@Slf4j
public class FeignController {
    @Resource
    PaymentService paymentService;

    @GetMapping("/payment/get")
    public String get() {
        return paymentService.get();
    }
}
