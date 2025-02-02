package com.exam.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    public Retryer myRetryer() {
        //最大请求次数为3(1+2)，初始间隔时间为100ms，重试间最大间隔时间为1s
//        return new Retryer.Default(100,1,3);
        return Retryer.NEVER_RETRY;//Feign默认配置是不走重试策略的
    }

    public Logger.Level feignLoggerLevel() {

        return Logger.Level.FULL;
    }
}
