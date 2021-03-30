package com.yzh.seata.service;

import com.yzh.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author simple
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    @PostMapping("/account/decrease")
    CommonResult<String> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal bigDecimal);
}
