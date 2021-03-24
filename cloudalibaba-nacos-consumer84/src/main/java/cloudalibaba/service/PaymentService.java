package cloudalibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author simple
 */
@FeignClient(value = "nacos-provider", fallback = PaymentExceptionHandlerService.class)
public interface PaymentService {
    @GetMapping("/nacos/get")
    String get();
}
