package com.exam.cloud.controller;
import com.exam.cloud.entities.PayDTO;
import com.exam.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    final String base = "http://cloud-payment-service";
    @Resource
    RestTemplate restTemplate;
    @GetMapping("/consumer/payment1/get/{id}")
    public ResultData getPayment(@PathVariable("id")Integer id) {
       return restTemplate.getForObject(base + "/pay/selectById/" + id, ResultData.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public ResultData getPayment1(@PathVariable("id")Integer id) {
        ResponseEntity<ResultData> responseEntity= restTemplate.getForEntity(base + "/pay/selectById/" + id, ResultData.class, id);
        return responseEntity.getBody();
    }
    @PostMapping("/consumer/payment/update")
    public ResultData update(@RequestBody PayDTO payDTO, HttpServletRequest request) {
        return restTemplate.postForObject(base + "/pay/update", payDTO, ResultData.class);
    }
    @GetMapping("/consumer/pay/get/info")
    public String getInfo() {
        return restTemplate.getForObject(base + "/pay/get/info", String.class);
    }
}
