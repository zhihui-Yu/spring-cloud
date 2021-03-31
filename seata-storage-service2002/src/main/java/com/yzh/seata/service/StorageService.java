package com.yzh.seata.service;

import com.yzh.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author simple
 */
public interface StorageService {
    CommonResult<String> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
