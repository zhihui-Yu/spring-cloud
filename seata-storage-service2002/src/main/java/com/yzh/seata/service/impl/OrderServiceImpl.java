package com.yzh.seata.service.impl;

import com.yzh.seata.dao.StorageDao;
import com.yzh.seata.service.StorageService;
import com.yzh.springcloud.entities.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author simple
 */
@Service
public class OrderServiceImpl implements StorageService {
    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Resource
    private StorageDao storageDao;

    @Override
    public CommonResult<String> decrease(Long productId, Integer count) {
        logger.info("开始扣减库存");
        storageDao.decrease(productId, count);
        return new CommonResult<>(204, "库存扣减成功。");
    }
}
