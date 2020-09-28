package com.yly.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.yly.springcloud.lb.MyLB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yiliyang
 * @version 1.0
 * @date 2020/9/23 上午10:16
 * @since 1.0
 */
@Configuration
public class RibbonGlobalLoadBalancingConfiguration {

    /**
     * 随机规则
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}