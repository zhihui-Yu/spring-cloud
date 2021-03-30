package com.yzh.seata.dao;

import com.yzh.seata.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author simple
 */
@Mapper
public interface OrderDao {
    void create(Order order);

    void update(@Param("id") Long id, @Param("status") Integer status);
}
