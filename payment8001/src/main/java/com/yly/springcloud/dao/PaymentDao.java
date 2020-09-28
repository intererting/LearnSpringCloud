package com.yly.springcloud.dao;

import com.yly.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    /**
     * 新增
     */
    int create(Payment payment);

    /**
     * 根据Id查询
     */
    Payment getPaymentById(@Param("id") Long id);
}
