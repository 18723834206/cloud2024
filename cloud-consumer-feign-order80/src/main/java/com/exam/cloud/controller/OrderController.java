package com.exam.cloud.controller;
import com.exam.cloud.apis.PayFeignApi;
import com.exam.cloud.entities.PayDTO;
import com.exam.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@RestController
public class OrderController {
    @Resource
    PayFeignApi payFeignApi;
    @GetMapping("/feign/payment1/get/{id}")
    public ResultData getPayment(@PathVariable("id")Integer id) {
       return  payFeignApi.getPayById(id);
    }
    @GetMapping("/feign/payment/get/{id}")
    public ResultData getPayment1(@PathVariable("id")Integer id) {

        return payFeignApi.getPayById(id);
    }
    @PostMapping("/feign/payment/update")
    public ResultData update(@RequestBody PayDTO payDTO) {
        return payFeignApi.update(payDTO);
    }
    @GetMapping("/feign/pay/get/info")
    public String getConsulInfo() throws InterruptedException {
        return payFeignApi.getConsulInfo();
    }

}
