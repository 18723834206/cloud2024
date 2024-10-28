package com.exam.cloud.apis;

import com.exam.cloud.entities.Pay;
import com.exam.cloud.entities.PayDTO;
import com.exam.cloud.resp.ResultCodeEnum;
import com.exam.cloud.resp.ResultData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.FileNotFoundException;
import java.util.List;

@FeignClient("cloud-payment-service")
public interface PayFeignApi {

    @PostMapping("/pay/add")
    public ResultData add(@RequestBody Pay pay);

    @GetMapping("/pay/delete/{id}")
    public ResultData delete(@PathVariable("id") Integer id);

    @PostMapping("/pay/update")
    public ResultData update(@RequestBody PayDTO payDTO);

    @GetMapping("/pay/selectById/{id}")
    public ResultData getPayById(@PathVariable("id") Integer id);

    @GetMapping("/pay/selectAll")
    public ResultData getPayALl();

    //    @Value("${csk}")
//    String csk;
    @GetMapping("/pay/get/info")
    public String getConsulInfo() ;

    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/bulkhead/{id}")
    public String myBulkhead(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/ratelimit/{id}")
    public String myRatelimit(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);
    @GetMapping("/pay/selectById/{id}")
    public ResultData getById(@PathVariable("id") Integer id);
    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo();
}

