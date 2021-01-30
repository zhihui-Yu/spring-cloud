package com.yzh.springcloud.controller;

import com.yzh.springcloud.entities.CommonResult;
import com.yzh.springcloud.entities.Payment;
import com.yzh.springcloud.loadbalance.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author simple
 */
@RestController
@Slf4j
public class OrderController {
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    LoadBalance loadBalance;
    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        logger.info("create");
        return restTemplate.postForObject(PAYMENT_URL + "/payment", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        logger.info("get");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get-for-entity/{id}")
    public CommonResult getForEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(500, "operation failed.");
        }
    }

    @PostMapping("/consumer/payment/post-for-entity/{id}")
    public CommonResult postForEntity(@RequestBody Payment payment) {
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment", payment, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(400, "post failed.");
        }
    }

    @GetMapping("/consumer/payment/load-balance")
    public String loadBalance() {
        List<ServiceInstance> services = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance service = loadBalance.choose(services);
        return restTemplate.getForObject(service.getUri() + "/payment/port", String.class);
    }
}
