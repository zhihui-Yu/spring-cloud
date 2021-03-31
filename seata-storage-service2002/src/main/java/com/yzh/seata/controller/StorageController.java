package com.yzh.seata.controller;

import com.yzh.seata.service.StorageService;
import com.yzh.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author simple
 */
@RestController
@Slf4j
public class StorageController {
    @Resource
    StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult<String> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        return storageService.decrease(productId, count);
    }
}
