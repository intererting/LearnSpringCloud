package com.yly.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author yiliyang
 * @version 1.0
 * @date 2020/10/22 上午9:29
 * @since 1.0
 */
@Slf4j
@Component
public class ScheduledWork {

    @Scheduled(cron = "1-10 * * * * ?")
//    @Scheduled(fixedRate = 2000)
    public void testScheduledWork() {
        log.info("testScheduledWork invoked");
    }
}
