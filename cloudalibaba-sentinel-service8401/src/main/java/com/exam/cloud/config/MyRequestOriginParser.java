package com.exam.cloud.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

//sentinel授权规则
@Component
public class MyRequestOriginParser implements RequestOriginParser
{
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        //授权参数serverName，控制台设置serverName的哪些值进入黑白名单
        return httpServletRequest.getParameter("serverName");
    }
}