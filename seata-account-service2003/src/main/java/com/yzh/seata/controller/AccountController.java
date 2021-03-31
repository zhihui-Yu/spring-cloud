package com.yzh.seata.controller;

import com.yzh.seata.domain.Account;
import com.yzh.seata.service.AccountService;
import com.yzh.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author simple
 */
@RestController
@Slf4j
public class AccountController {
    @Resource
    AccountService accountService;

    @PostMapping("/account/decrease")
    CommonResult<String> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult<>(200, "扣款成功。");
    }

    @PostMapping("/account/create")
    CommonResult<String> create(@RequestBody Account account) {
        accountService.create(account);
        return new CommonResult<>(201, "用户创建成功。");
    }
}
