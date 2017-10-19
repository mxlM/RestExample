
package com.panodata.mapper;

import com.panodata.model.*;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RedisSourcePOMapper {

    //模型
    @Select("select * from risk_model")
    List<RiskModelPO> findAllModel();

    //规则组
    @Select("select * from risk_grouprule")
    List<RiskGrouprulePO> findAllGroup();

    //规则组明细
    @Select("select * from risk_grouprule_detail")
    List<RiskGroupruleDetailPO> findAllGroupruleDetail();

    //规则
    @Select("select * from risk_rule")
    List<RiskRulePO> findAllRule();

    //数元表
    @Select("select * from risk_element")
    List<RiskElementPO> findAllElement();

    //数元明细
    @Select("select * from risk_element_detail")
    List<RiskElementDetailPO> findAllElementDetail();

    //数元类型（系统数元，常量，用户自定义变量）
    @Select("select * from risk_element_type")
    List<RiskElementTypePO> findAllElementType();

    //原子
    @Select("select * from risk_atom")
    List<RiskAtomPO> findAllAtom();

    //原子url组成
    @Select("select * from risk_url_version")
    List<RiskUrlVersionPO> findAllUrlVersionPO();

    //原子的输入参数
    @Select("select * from risk_atom_input_params")
    List<RiskAtomInputParamsPO>  findAllAtomInputParamsPO();

    //关联risk_atom_input_param_bind_businessfieldid表的atominputparamid    原子输入参数关联出businessid
    @Select("select * from risk_atom_input_param_bind_businessfieldid")
    List<RiskAtomInputParamBindBusinessfieldidPO> findAllAtomInputParamBindBusinessfieldid();

    //原子的输出参数
    @Select("select * from risk_atom_output_params")
    List<RiskAtomOutputParamsPO>  findAllAtomOutputParamsPO();

    // 获取自定义变量，对应的数据类型id
    @Select("select * from risk_business_fields")
    List<RiskBusinessFieldsPO> findAllBusinessFields();

    //数据类型（自定义变量，常量）
    @Select("select * from risk_value_type")
    List<RiskValueTypePO>  findAllValueExpress();

    //计算表达式表
    @Select("select * from risk_calc_express")
    List<RiskCalcExpressPO>  findAllCalcExpress();


    //通过流水号（seqId），（businessId）获取对应值（businessValue）
    @Select("select * from risk_calling_detail where seqId = #{seqId} and businessId = #{businessId}")
    RiskCallingDetailPO  findCallingDetail(@Param("seqId") String seqId, @Param("businessId") String businessId);

    //获取所有流水数据
    @Select("select * from risk_calling_detail")
    List<RiskCallingDetailPO>  findAllCallingDetail();

    //更新token信息,根据id
    @Update("UPDATE risk_url_version SET token=#{token} WHERE id =#{id}")
    int update_token(@Param("id") String id,@Param("token") String token);

}
