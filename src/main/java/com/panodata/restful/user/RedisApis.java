package com.panodata.restful.user;

import com.panodata.conf.base.BaseController;
import com.panodata.conf.redis.RedisService;
import com.panodata.conf.response.ResponseResult;
import com.panodata.conf.response.ResponseSuccessEnum;
import com.panodata.conf.response.RestResultGenerator;
import com.panodata.model.Entity.ResoultPo;
import com.panodata.model.RiskAtomPO;
import com.panodata.model.RiskCallingDetailPO;
import com.panodata.model.RiskModelPO;
import com.panodata.service.user.RedisSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



/**
 * redis 对外接口类
 **/
@RestController
@RequestMapping("/api")
public class RedisApis extends BaseController {

    @Autowired
    private RedisSourceService redisSourceService;  //业务类

    @Autowired
    private RedisService redisService;  //redis相关


    //获取模型数据
    @RequestMapping(value = "/pano/data/ModelPO/{modelPoId}", method = RequestMethod.GET)
    public ResponseResult<RiskModelPO> get(@PathVariable String modelPoId) throws Exception {

        RiskModelPO riskModelPO =null;
        try {
            //从redis中获取数据
            String mkey = "m:"+modelPoId;
            riskModelPO = redisSourceService.get_model(mkey);
            System.out.print("DATA FROM REDIS!");
        }catch (Exception e){
            //从数据库方式获取数据
            riskModelPO = redisSourceService.getResoultPo(modelPoId);
            System.out.print("DATA FROM MYSQL!");
        }

        if(riskModelPO==null){
            return RestResultGenerator.genResult(riskModelPO,ResponseSuccessEnum.PARAMETER_ERROR);
        }
        return RestResultGenerator.genResult(riskModelPO,ResponseSuccessEnum.SUCCESS);
    }

    //通过流水号（seqId），（businessId）获取对应值（businessValue）
    @RequestMapping(value = "/pano/data/calling_detail/{seqId}/{businessId}", method = RequestMethod.GET)
    public ResponseResult<RiskCallingDetailPO> get(@PathVariable String seqId,@PathVariable String businessId) throws Exception {

        RiskCallingDetailPO  callingDetail =null;
        try{
            //从redis中获取数据
            String ckey = "c:"+seqId+":"+businessId;
            callingDetail = redisSourceService.get_businessValue(ckey);
            System.out.print("DATA FROM REDIS!");
        }catch (Exception e){
            //从数据库中获取数据
            callingDetail = redisSourceService.findCallingDetail(seqId,businessId);
            System.out.print("DATA FROM MYSQL!");
        }

        if( callingDetail==null ){
            return RestResultGenerator.genResult(callingDetail,ResponseSuccessEnum.PARAMETER_ERROR);
        }
        return RestResultGenerator.genResult(callingDetail,ResponseSuccessEnum.SUCCESS);
    }

    //更新token信息,根据id  String id,String token
    @RequestMapping(value = "/pano/data/url_version/{id}/{token}", method = RequestMethod.GET)
    public ResponseResult<Boolean> updatetoken(@PathVariable String id, @PathVariable String token) throws Exception {
         int i = redisSourceService.update_token(id,token) ;
         Boolean check=false;
         if(i>0){
             check=true;
             return RestResultGenerator.genResult(check,ResponseSuccessEnum.SUCCESS);
         }
        return RestResultGenerator.genResult(check,ResponseSuccessEnum.UPDATE_ERROR);
    }

}

