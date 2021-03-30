package com.yzh.seata.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author simple
 */
@Configuration
@MapperScan({"com.yzh.seata.dao"})
public class MybatisConfig {
}
