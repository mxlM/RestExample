
package com.panodata.order;

import com.alibaba.fastjson.JSON;
import com.panodata.conf.redis.RedisService;
import com.panodata.model.RiskModelPO;
import com.panodata.service.user.RedisSourceService;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Component  组件化的注解   简单来说就是   这个类  既不是 controller  又不是  service   又不是  Repository  的时候，反正就是定位不清晰的时候，就可以用这个，表示这是个组件
 *
 * Order    代表这是一个任务，具体执行什么不一定，一般作为 MQ 的监听  或者应用启动时初始化部分数据的东西  实现CommandLineRunner  的 run 接口可以在里面写执行任务   当然不实现也行。。。。
 * value代表任务启动顺序，可以定义多个任务，根据value按顺序启动
 *
 * Created by wp_sp on 2017/8/1.
 */

@Component
@org.springframework.core.annotation.Order(value = 1)
public class Order implements CommandLineRunner {

    @Autowired
    private RedisService redisService;
    @Autowired
    private RedisSourceService redisSourceService;

    private static Logger logger = Logger.getLogger(CommandLineRunner.class);


    @Override
    public void run(String... strings) throws Exception {

        logger.info("进入初始化run方法---");

        //根据模型id插入所有模型数据
        String modelPoId = "M000001";
        redisSourceService.insert_redis_start(modelPoId);

        //插入所有流水数据
        redisSourceService.insert_redis_allbusiness();
    }

}
