package com.yzh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

/**
 * @author simple
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB() {
        System.out.println(ZonedDateTime.now() + "--" + Thread.currentThread().getName() + "-- testB");
        return "----testB";
    }

    private final Logger logger = LoggerFactory.getLogger(FlowLimitController.class);

    @GetMapping("/testC")
    public String testC() {
        logger.info("慢调用测试");
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "----testC";
    }

    @GetMapping("/testD")
    public String testD() {
        logger.info("异常比例测试");
        int i = 10 / 0;
        return "----testD";
    }

    @GetMapping("/testE")
    public String testE() {
        logger.info("异常数测试");
        int i = 10 / 0;
        return "----testD";
    }

    @GetMapping("/testF")
    @SentinelResource(value = "testF", blockHandler = "hotKey")
    public String testF(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2) {
        logger.info("testF--hot key");
//        int i = 10 / 0;
        return "----testF";
    }

    public String hotKey(String p1, String p2, BlockException blockException) {
        return "hot-key";
    }
}
