package com.yly.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
    /**
     * 获取存活的服务实例列表
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
