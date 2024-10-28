package com.exam.cloud.controller;

import com.exam.cloud.apis.PayFeignApi;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdercircuitController {
    @Resource
    PayFeignApi payFeignApi;
    @CircuitBreaker(name = "cloud-payment-service",fallbackMethod = "myCircuitFallback")
    @GetMapping("/feign/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id")Integer id) {
        return payFeignApi.myCircuit(id);
    }
    public String myCircuitFallback(Integer id,Throwable t) {
        return "myCircuitFallback,系统繁忙请稍后再试";

    }
    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadFallback",type = Bulkhead.Type.SEMAPHORE)
    @GetMapping("feign/pay/bulkhead/{id}")
    public String myBulkhead(@PathVariable("id")Integer id) {
        return payFeignApi.myBulkhead(id);
    }

    public String myBulkheadFallback(Integer id,Throwable t) {
        return "myBulkheadFallback,隔板超过最大数量限制，系统繁忙请稍后再试";
    }
    @GetMapping(value = "/feign/pay/ratelimit/{id}")
    @RateLimiter(name="cloud-payment-service",fallbackMethod = "myRatelimitFallback")
    public String myRatelimit(@PathVariable("id") Integer id){
        return payFeignApi.myRatelimit(id);
    }
    public String myRatelimitFallback(Integer id,Throwable t) {
        return "你被限流了，禁止访问/(ㄒoㄒ)/~~";
    }
}
