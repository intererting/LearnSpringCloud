package com.yly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosClient3377Main {
    public static void main(String[] args) {
        SpringApplication.run(NacosClient3377Main.class, args);
    }
}
