package com.yzh.seata.service.impl;

import com.yzh.seata.dao.OrderDao;
import com.yzh.seata.domain.Order;
import com.yzh.seata.service.AccountService;
import com.yzh.seata.service.OrderService;
import com.yzh.seata.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author simple
 */
@Service
public class OrderServiceImpl implements OrderService {
    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "order-create", rollbackFor = Exception.class)
    public void create(Order order) {
        System.out.println(order);
        logger.info("start create order.");
        orderDao.create(order);
        logger.info("start decrease storage.");
        storageService.decrease(order.getProductId(), order.getCount());
        logger.info("start decrease account.");
        int i = 1/0;
        accountService.decrease(order.getUserId(), order.getMoney());
        logger.info("modify order status");
        orderDao.update(order.getId(), order.getStatus());
        logger.info("order create success.");
    }
}
