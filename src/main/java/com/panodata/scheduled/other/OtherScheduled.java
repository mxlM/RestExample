package com.panodata.scheduled.other;

import com.panodata.mapper.UserPOMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 其他定时任务
 * Created by wp_sp on 2017/9/22.
 */
@Component
public class OtherScheduled implements SchedulingConfigurer {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private final Logger logger = Logger.getLogger(getClass());
    private static final String DEFAULT_CRON = "0/5 * * * * ?";
    private String cron = DEFAULT_CRON;
    private String cron2 = DEFAULT_CRON;

    @Autowired
    private UserPOMapper userPOMapper;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                logger.info("动态修改定时任务cron参数，当前时间：" + dateFormat.format(new Date()));
//                List<UserPO> users = userPOMapper.findAll();
//                logger.info("查询并打印userid：" + user.getUserInfoId());
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 定时任务触发，可修改定时任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExecDate = trigger.nextExecutionTime(triggerContext);
                return nextExecDate;
            }
        });

        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                logger.info("动态修改定时任务cron2参数，当前时间：" + dateFormat.format(new Date()));
//                logger.info("我就执行一个任务玩玩");
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 定时任务触发，可修改定时任务的执行周期
                CronTrigger trigger = new CronTrigger(cron2);
                Date nextExecDate = trigger.nextExecutionTime(triggerContext);
                return nextExecDate;
            }
        });
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public void setCron2(String cron2) {
        this.cron2 = cron2;
    }
}
