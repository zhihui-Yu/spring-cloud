package com.yzh.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author simple
 */
@Component
public class MyselfLoadBalance implements LoadBalance {
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    private int getAndIncrement() {
        int cur, next;
        do {
            cur = atomicInteger.get();
            next = cur >= Integer.MAX_VALUE ? 0 : cur + 1;
        } while (!atomicInteger.compareAndSet(cur, next));
        System.out.println("------ next: " + next);
        return next;
    }

    @Override
    public ServiceInstance choose(List<ServiceInstance> serviceInstances) {
        if (serviceInstances == null || serviceInstances.isEmpty()) return null;
        int serviceIndex = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(serviceIndex);
    }
}
