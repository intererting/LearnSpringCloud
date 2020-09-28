package com.yly.springcloud.service.impl;

import com.yly.springcloud.dao.PaymentDao;
import com.yly.springcloud.entities.Payment;
import com.yly.springcloud.service.PaymentService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    /**
     * 新增
     */
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    /**
     * 根据Id查询
     */
    @Override
    @Cacheable(value = "payment", key = "#id")//spring cache 存储格式{value:{key,result}}
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    @CacheEvict(value = "payment", key = "#id")
    public void evictPaymentCache(Long id) {

    }

    @Override
    @CachePut(value = "payment", key = "#id")
    public Payment putPaymentCache(Long id, Payment payment) {
        return payment;
    }
}
