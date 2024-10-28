package com.exam.cloud.resp;

import lombok.Data;

@Data
public class ResultData<T> {
    private Integer code;
    private String message;
    private T data;
    private long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> ok() {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ResultCodeEnum.RC200.getCode());
        resultData.setMessage(ResultCodeEnum.RC200.getMessage());
        return resultData;
    }
    public static <T> ResultData<T> ok(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ResultCodeEnum.RC200.getCode());
        resultData.setMessage(ResultCodeEnum.RC200.getMessage());
        resultData.setData(data);
        return resultData;
    }
    public static <T> ResultData<T> error(Integer code,String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }



}
