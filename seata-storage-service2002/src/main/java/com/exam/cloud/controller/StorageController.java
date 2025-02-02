package com.exam.cloud.controller;

import com.exam.cloud.resp.ResultData;
import com.exam.cloud.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController
{
    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public ResultData<String> decrease(Long productId, Integer count) {

        storageService.decrease(productId, count);
        return ResultData.ok("扣减库存成功!");
    }
}