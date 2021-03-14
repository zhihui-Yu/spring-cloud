package cloudalibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simple
 */
@RestController
@Slf4j
public class NacosController {
    @Value("${server.port}")
    String port;

    @GetMapping("/nacos/get")
    public String get() {
        return "server-port: " + port;
    }
}
