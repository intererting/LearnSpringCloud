package com.yly.springcloud.controller;

import com.yly.springcloud.beans.Student;
import com.yly.springcloud.config.ScheduledWork;
import com.yly.springcloud.entities.CommonResult;
import com.yly.springcloud.entities.Payment;
import com.yly.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    private Student student;

    @Autowired
    public void setStudent(Student student) {
        this.student = student;
    }

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

//    /**
//     * 服务发现 获取服务信息
//     */
//    @Resource
//    private DiscoveryClient discoveryClient;

    /**
     * 新增
     * postman http://localhost:8001/payment/create?serial=atguigu002
     */
    @PostMapping(value = "payment/create")
    public CommonResult<Payment> create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果: " + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入数据库成功,serverPort:" + serverPort);
        }
        return new CommonResult<>(444, "插入数据库失败");
    }

    /**
     * 查询
     * http://localhost:8001/payment/get/31
     */
    @GetMapping(value = "payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        System.out.println(student.getName());
        System.out.println(student.getBook().getName());
        try {
            //用于测试feign的超时
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果: " + payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功,serverPort:" + serverPort, payment);
        }
        return new CommonResult<>(444, "没有对应记录,查询ID:" + id);
    }

    @DeleteMapping(value = "payment/evict/{id}")
    public void evictPaymentCache(@PathVariable Long id) {
        paymentService.evictPaymentCache(id);
    }

    @PutMapping(value = "payment/update")
    public void putPaymentCache() {
        paymentService.putPaymentCache(1L, new Payment(2L, "update cache"));
    }


//    /**
//     * 服务发现
//     */
//    @GetMapping(value = "payment/discovery")
//    public Object discovery() {
//        List<String> services = discoveryClient.getServices();
//        for (String element : services) {
//            log.info("*****element:" + element);
//        }
//        // 一个微服务下的全部实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//        for (ServiceInstance instance : instances) {
//            log.debug(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + instance.getUri());
//        }
//        return this.discoveryClient;
//    }
//
//    @GetMapping(value = "/payment/lb")
//    public String getPaymentLB() {
//        return serverPort;
//    }
//
//
//    @GetMapping(value = "/payment/feign/timeout")
//    public String paymentFeignTimeout() {
//        try {
//            // 暂停3秒钟
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return serverPort;
//    }
//
//    /**
//     * 链路跟踪
//     *
//     * @return
//     */
//    @GetMapping(value = "/payment/zipkin")
//    public String paymentZipkin() {
//        return "hi,i'am paymentZipkin server fall back,welcome to atguigu,O(∩_∩)O哈哈~";
//    }
}
