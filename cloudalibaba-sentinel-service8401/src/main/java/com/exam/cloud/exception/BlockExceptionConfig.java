package com.exam.cloud.exception;

public class BlockExceptionConfig {
    public static String blockError(com.alibaba.csp.sentinel.slots.block.BlockException e) {
        return "block异常";
    }
}
