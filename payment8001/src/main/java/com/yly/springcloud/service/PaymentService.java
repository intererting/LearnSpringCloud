package com.yly.springcloud.service;

import com.yly.springcloud.entities.Payment;

public interface PaymentService {
    /**
     * 新增
     */
    int create(Payment payment);

    /**
     * 根据Id查询
     */
    Payment getPaymentById(Long id);

    /**
     * 测试删除spring cache
     */
    void evictPaymentCache(Long id);

    /**
     * 测试更新Spring 缓存
     */
    Payment putPaymentCache(Long id, Payment payment);


}
