package com.exam.cloud.resp;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    RC200(200,"success"),
    RC404(404,"404页面找不到的异常"),
    RC500(500,"系统异常，请稍后重试"),
    RC375(375,"数学运算异常，请稍后重试"),
    RC400(400,"操作失败")

    ;

    private final Integer code;
    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
