package com.exam.cloud.controller;
import com.exam.cloud.entities.Pay;
import com.exam.cloud.entities.PayDTO;
import com.exam.cloud.resp.ResultCodeEnum;
import com.exam.cloud.resp.ResultData;
import com.exam.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;


@RestController
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Resource
    PayService payService;
    @PostMapping("/pay/add")
    @Operation(summary = "新增",description = "新增支付流水")
    public ResultData add(@RequestBody Pay pay) {
        int i = payService.add(pay);
        if (i > 0) {
            return ResultData.ok();
        }
        return ResultData.error(ResultCodeEnum.RC400.getCode(), ResultCodeEnum.RC400.getMessage());

    }
    @Operation(summary = "删除",description = "根据id进行删除")
    @GetMapping("/pay/delete/{id}")
    public ResultData delete(@PathVariable("id") Integer id) {
        int i = payService.delete(id);
        if (id<0) {
            throw new RuntimeException("id不能为负数");
        }
        if (i > 0) {
            return ResultData.ok();
        }
        return ResultData.error(ResultCodeEnum.RC400.getCode(), ResultCodeEnum.RC400.getMessage());
    }
    @Operation(summary = "更新",description = "支付数据更新")
    @PostMapping("/pay/update")
    public ResultData update(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        int i = payService.update(pay);
        if (i > 0) {
            return ResultData.ok();
        }
        return ResultData.error(ResultCodeEnum.RC400.getCode(), ResultCodeEnum.RC400.getMessage());
    }
    @Operation(summary = "查询",description = "根据id进行查询")
    @GetMapping("/pay/selectById/{id}")
    public ResultData getPayById(@PathVariable("id") Integer id) {
        Pay pay = payService.getById(id);
        return ResultData.ok(pay);
    }
    @Operation(summary = "查询所有",description = "查询所有支付数据")
    @GetMapping("/pay/selectAll")
    public ResultData getPayALl() throws FileNotFoundException {
        List<Pay> l = payService.getAll();
        return ResultData.ok(l);
    }

//    @Value("${csk}")
//    String csk;
    @GetMapping("/pay/get/info")
    public String getConsulInfo(@Value("${csk}")String csk) throws InterruptedException {
        return csk+"8001";
    }
}
