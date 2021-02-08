package com.yzh.springcloud.service.impl;

import com.yzh.springcloud.service.SimpleService;
import org.springframework.stereotype.Service;

/**
 * @author simple
 */
@Service
public class SimpleServiceImpl implements SimpleService {
    @Override
    public String ok(String id) {
        return "Thread-name: " + Thread.currentThread().getName() + "\t id = " + id;
    }

    @Override
    public String timeout(String id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Thread-name: " + Thread.currentThread().getName() + "\t id = " + id;
    }
}
