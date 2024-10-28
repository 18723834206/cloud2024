package com.exam.cloud.controller;

import com.exam.cloud.apis.PayFeignApi;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OderMicrometerController {
    @Resource
    PayFeignApi payFeignApi;
    @GetMapping(value = "/feign/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id){
        return payFeignApi.myMicrometer(id);
    }

}
