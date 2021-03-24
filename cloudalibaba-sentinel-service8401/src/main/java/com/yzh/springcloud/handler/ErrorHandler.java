package com.yzh.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author simple
 */
public class ErrorHandler {
    public static String handler1(BlockException blockException) {
        return "handler 1";
    }

    public static String handler2(BlockException blockException) {
        return "handler 2";
    }
}
