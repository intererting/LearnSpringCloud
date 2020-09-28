package com.yly.springcloud.service;

import com.yly.springcloud.config.FeignConfiguration;
import com.yly.springcloud.entities.CommonResult;
import com.yly.springcloud.entities.Payment;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service", configuration = FeignConfiguration.class)
public interface FeignService {

    //    @LoadBalanced
    @GetMapping(value = "payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
