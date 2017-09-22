package com.panodata.scheduled.user;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 用户定时任务
 * Created by wp_sp on 2017/9/22.
 */
@Component
public class UserScheduled {
    private static Logger logger = Logger.getLogger(UserScheduled.class);  //log4j 日志配置

    @Scheduled(fixedRate = 1000) // 固定时间间隔
    public void one() {
        logger.info("UserScheduled-one:"+new Date());
        //具体的业务逻辑
    }

    @Scheduled(fixedDelay = 500) // 等待时间间隔
    public void two() {
        logger.info("UserScheduled-two:"+new Date());
        //具体的业务逻辑
    }

    @Scheduled(cron = "0/4 * * * * ?") // 等待时间间隔
    public void three() {
        logger.info("UserScheduled-three:"+new Date());
        //具体的业务逻辑
    }
}
