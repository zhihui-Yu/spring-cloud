package com.yzh.seata.controller;

import com.yzh.seata.domain.Order;
import com.yzh.seata.service.OrderService;
import com.yzh.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author simple
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    OrderService orderService;

    @PostMapping("/order/create")
    public CommonResult<String> create(@RequestBody Order order){
        orderService.create(order);
        return new CommonResult<String>(200,"创建订单成功");
    }
}
