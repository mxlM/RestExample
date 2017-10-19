
package com.panodata.service.user;

import com.panodata.model.*;
import com.panodata.model.Entity.ResoultPo;
import java.util.List;


/**
 * Created by quyuan on 2017/9/28.
 */

public interface RedisSourceService {

    //模型
    List<RiskModelPO> findAllModel();

    //规则组
    List<RiskGrouprulePO> findAllGroup();
    //规则组明细
    List<RiskGroupruleDetailPO> findAllGroupruleDetail();

    //规则
    List<RiskRulePO> findAllRule();

    //数元表
    List<RiskElementPO> findAllElement();

    //数元明细
    List<RiskElementDetailPO> findAllElementDetail();

    //数元类型（系统数元，常量，用户自定义变量）
    List<RiskElementTypePO> findAllElementType();

    //原子表
    List<RiskAtomPO> findAllAtom();

    //原子url组成
    List<RiskUrlVersionPO> findAllUrlVersionPO();

    //原子的输入参数
    List<RiskAtomInputParamsPO>  findAllAtomInputParams();

    //关联risk_atom_input_param_bind_businessfieldid表的atominputparamid    原子输入参数关联出businessid
    List<RiskAtomInputParamBindBusinessfieldidPO> findAllAtomInputParamBindBusinessfieldid();

    //原子的输出参数
    List<RiskAtomOutputParamsPO>  findAllAtomOutputParams();

    //获取自定义变量，对应的数据类型id
    List<RiskBusinessFieldsPO> findAllBusinessFields();

    //数据类型（自定义变量，常量）
    List<RiskValueTypePO>  findAllValueExpress();

    //计算表达式表
    List<RiskCalcExpressPO>  findAllCalcExpress();


    //通过流水号（seqId），（businessId）获取对应值（businessValue）
    RiskCallingDetailPO  findCallingDetail( String seqId,String businessId);

    //获取所有流水数据
    List<RiskCallingDetailPO>  findAllCallingDetail();

    //更新token信息,根据id
    int  update_token(String id,String token);

    //封装返回所有信息
    RiskModelPO getResoultPo(String input_modelid);


    //---------------------------------------------------往redis中存入数据------------------------------------------------

    //根据模型id获取各部分数据插入redis
    public void insert_redis_start(String input_modelid);

    //插入流水表中所有数据
    public void insert_redis_allbusiness();

    //插入流水表中输入参数数据businessValue
    public void insert_businessValue(RiskCallingDetailPO callingDetailPO);
    //获取流水表输入参数数据
    public RiskCallingDetailPO get_businessValue(String key);

    //宽表(根据id直接查询原子信息，最小粒度)
    public void insert_atom(String akey,RiskAtomPO atom);
    //获取原子值
    public RiskAtomPO get_atom(String key);

    //插入模型
    public void insert_model(RiskModelPO riskModelPO);
    //获取模型
    public RiskModelPO get_model(String key);

    //插入规则组
    public void insert_rulegroup(RiskGrouprulePO  grouprule);
    //获取规则组
    public RiskGrouprulePO get_rulegroup(String key);

    //插入规则表
    public void insert_rule(RiskRulePO RiskRulePO);
    //获取规则
    public RiskRulePO get_rule(String key);

    //插入数元表
    public void insert_element(RiskElementPO riskElement);
    //获取数元
    public RiskElementPO get_element(String key);

}

