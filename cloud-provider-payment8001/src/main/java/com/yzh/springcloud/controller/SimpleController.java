package com.yzh.springcloud.controller;

import com.yzh.springcloud.entities.CommonResult;
import com.yzh.springcloud.entities.Payment;
import com.yzh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class SimpleController {
    private final Logger logger = LoggerFactory.getLogger(SimpleController.class);
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        logger.info("========== services ==============");
        for (String service : services) {
            logger.info("service: " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        logger.info("========== instances ==============");
        for (ServiceInstance serviceInstance : instances) {
            logger.info("serviceId" + serviceInstance.getServiceId());
            logger.info("host: " + serviceInstance.getHost());
            logger.info("port: " + serviceInstance.getPort());
            logger.info("uri: " + serviceInstance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/payment/port")
    public String port() {
        return port;
    }

    @GetMapping("/payment/timeout")
    public String timeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }
}
