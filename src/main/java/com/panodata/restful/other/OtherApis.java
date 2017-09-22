package com.panodata.restful.other;

import com.panodata.conf.base.BaseController;
import com.panodata.scheduled.other.OtherScheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wp_sp on 2017/9/22.
 */
public class OtherApis extends BaseController {

    @Autowired
    private OtherScheduled otherScheduled;


    // 更新动态任务时间
    @RequestMapping("/updateDynamicScheduledTask")
    @ResponseBody
    public String updateDynamicScheduledTask() {
        otherScheduled.setCron("0/10 * * * * ?");
        return "ok";
    }

    // 更新动态任务时间2
    @RequestMapping("/updateDynamicScheduledTask2")
    @ResponseBody
    public String updateDynamicScheduledTask2() {
        otherScheduled.setCron2("0/10 * * * * ?");
        return "ok";
    }

}
