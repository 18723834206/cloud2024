package com.exam.cloud;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class MyTest {
    @Resource
    DiscoveryClient discoveryClient;
    @Test
    public void myTest() {
        List<ServiceInstance> instances = discoveryClient.getInstances("STORES");
        if (!instances.isEmpty() && instances != null) {
            System.out.println(instances.get(0));

        }
    }
}
