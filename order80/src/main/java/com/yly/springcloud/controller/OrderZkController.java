package com.yly.springcloud.controller;

import com.yly.springcloud.entities.CommonResult;
import com.yly.springcloud.entities.Payment;
import com.yly.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderZkController {

    public static final String INVOKE_URL = "http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping(value = "consumer/get/{id}")
    @LoadBalanced
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
//        if (instances == null || instances.size() <= 0) {
//            return null;
//        }
//        ServiceInstance serviceInstance = loadBalancer.instances(instances);
//        URI uri = serviceInstance.getUri();
//        String url = uri + "/payment/get/" + id;
//        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(
//                url,
//                CommonResult.class);
//        if (responseEntity.getStatusCode().is2xxSuccessful()) {
//            return responseEntity.getBody();
//        } else {
//            return new CommonResult<>(500, "失败");
//        }

        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(INVOKE_URL + "/payment/get/" + id,
                CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return new CommonResult<>(500, "失败");
        }
    }
}
