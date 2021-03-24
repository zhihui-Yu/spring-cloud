package cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author simple
 */
@Slf4j
@RestController
public class NacosController {
    @Value("${server.port}")
    String port;
    @Value("${nacos.provider-url}")
    String serviceURL;
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/nacos/get")
    @SentinelResource(value = "get", fallback = "fallback", blockHandler = "blockHandler", exceptionsToIgnore = {IllegalArgumentException.class})
    public String get() {
        return restTemplate.getForObject(serviceURL + "/nacos/get", String.class);
    }

    public String fallback() {
        return "fall back now.";
    }

    public String blockHandler(BlockException blockException) {
        return "block-exception";
    }
}
