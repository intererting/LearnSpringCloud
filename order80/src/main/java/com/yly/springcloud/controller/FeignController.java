package com.yly.springcloud.controller;

import com.yly.springcloud.entities.CommonResult;
import com.yly.springcloud.entities.Payment;
import com.yly.springcloud.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    private final FeignService feignService;

    @Autowired
    public FeignController(FeignService feignService) {
        this.feignService = feignService;
    }

    @GetMapping(value = "feign/consumer/get/{id}")
//    @LoadBalanced
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return feignService.getPaymentById(id);
    }
}
