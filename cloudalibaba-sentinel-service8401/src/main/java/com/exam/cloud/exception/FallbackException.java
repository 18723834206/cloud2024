package com.exam.cloud.exception;

import org.springframework.stereotype.Component;


public class FallbackException {
    public static String fallbackError() {
        return "fallbackError异常";
    }
    public static String errorInfo(Throwable t) {

        return "服务异常，请稍后再试";
    }
}
