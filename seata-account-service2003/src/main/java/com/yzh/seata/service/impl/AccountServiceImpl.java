package com.yzh.seata.service.impl;

import com.yzh.seata.dao.AccountDao;
import com.yzh.seata.domain.Account;
import com.yzh.seata.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author simple
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.decrease(userId, money);
    }

    @Override
    public void create(Account account) {
        accountDao.create(account);
    }
}
