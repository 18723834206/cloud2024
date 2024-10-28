package com.exam.cloud.exception;

import com.exam.cloud.resp.ResultCodeEnum;
import com.exam.cloud.resp.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GloableExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResultData exception(Exception e) {
        log.error("全局异常信息exception()"+e.getMessage(),e);
        return ResultData.error(ResultCodeEnum.RC500.getCode(), e.getMessage());
    }
}
