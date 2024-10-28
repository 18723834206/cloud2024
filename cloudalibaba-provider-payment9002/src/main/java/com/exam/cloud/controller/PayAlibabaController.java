package com.exam.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayAlibabaController {
    @Value("${server.port}")
    String serverPort;

    @RequestMapping("/pay/nacos/{id}")
    public String getPayInfo(@PathVariable("id")Integer id) {
        return "nacos registry,serverPort:"+serverPort+"\t id:"+id;

    }
}
