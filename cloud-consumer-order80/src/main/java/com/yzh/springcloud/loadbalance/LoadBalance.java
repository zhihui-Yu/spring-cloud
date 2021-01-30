package com.yzh.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author simple
 */
public interface LoadBalance {
    ServiceInstance choose(List<ServiceInstance>serviceInstances);
}
