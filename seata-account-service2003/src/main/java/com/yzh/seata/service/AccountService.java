package com.yzh.seata.service;

import com.yzh.seata.domain.Account;

import java.math.BigDecimal;

/**
 * @author simple
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);

    void create(Account account);
}
