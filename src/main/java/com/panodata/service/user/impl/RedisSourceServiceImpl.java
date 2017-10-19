package com.panodata.service.user.impl;

import com.alibaba.fastjson.JSON;
import com.panodata.mapper.RedisSourcePOMapper;
import com.panodata.model.*;
import com.panodata.model.Entity.ResoultPo;
import com.panodata.service.user.RedisSourceService;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.*;


/**
 * Created by quyuan on 2017/9/28.
 */

@Service
public class RedisSourceServiceImpl implements RedisSourceService {

    //Jedis redis = new Jedis("192.168.0.235",6379);  //测试环境
    Jedis redis = new Jedis("192.168.203.100",6379);//本地环境

    @Autowired
    private RedisSourcePOMapper RedisSourcePOMapper;

    //模型
    @Override
    public List<RiskModelPO> findAllModel() {return RedisSourcePOMapper.findAllModel();}

    //规则组
    @Override
    public List<RiskGrouprulePO> findAllGroup() {
        return RedisSourcePOMapper.findAllGroup();
    }

    //规则组明细
    @Override
    public List<RiskGroupruleDetailPO> findAllGroupruleDetail() {
        return RedisSourcePOMapper.findAllGroupruleDetail();
    }

    //规则
    @Override
    public List<RiskRulePO> findAllRule() {
        return RedisSourcePOMapper.findAllRule();
    }

    //数元表
    @Override
    public List<RiskElementPO> findAllElement() {
        return RedisSourcePOMapper.findAllElement();
    }

    //数元明细
    @Override
    public List<RiskElementDetailPO> findAllElementDetail() {
        return RedisSourcePOMapper.findAllElementDetail();
    }

    //数元类型（系统数元，常量，用户自定义变量）
    @Override
    public List<RiskElementTypePO> findAllElementType() {
        return RedisSourcePOMapper.findAllElementType();
    }

    //原子表
    @Override
    public List<RiskAtomPO> findAllAtom() {
        return RedisSourcePOMapper.findAllAtom();
    }

    //原子url组成
    @Override
    public List<RiskUrlVersionPO> findAllUrlVersionPO() {
        return RedisSourcePOMapper.findAllUrlVersionPO();
    }

    //原子的输入参数
    @Override
    public List<RiskAtomInputParamsPO> findAllAtomInputParams() {
        return RedisSourcePOMapper.findAllAtomInputParamsPO();
    }

    //关联risk_atom_input_param_bind_businessfieldid表的atominputparamid    原子输入参数关联出businessid
    @Override
    public List<RiskAtomInputParamBindBusinessfieldidPO> findAllAtomInputParamBindBusinessfieldid() {
        return RedisSourcePOMapper.findAllAtomInputParamBindBusinessfieldid();
    }

    //原子的输出参数
    @Override
    public List<RiskAtomOutputParamsPO> findAllAtomOutputParams() {
        return RedisSourcePOMapper.findAllAtomOutputParamsPO();
    }

    //计算表达式表
    @Override
    public List<RiskCalcExpressPO> findAllCalcExpress() {
        return RedisSourcePOMapper.findAllCalcExpress();
    }

    //通过流水号（seqId），（businessId）获取对应值（businessValue）
    @Override
    public RiskCallingDetailPO findCallingDetail(String seqId, String businessId) {
        return RedisSourcePOMapper.findCallingDetail(seqId,businessId);
    }

    //获取所有流水数据
    @Override
    public List<RiskCallingDetailPO> findAllCallingDetail(){
        return RedisSourcePOMapper.findAllCallingDetail();
    }

    /**说明：
     * 1.用户自定义变量：（数元id 对应risk_business_fields表id再拿datetypeid，对应表risk_value_express的id拿value值）
     * 2.系统数元：根据中间表查数元表
     * 3.常量：拿valueexpresstypeid  对应表risk_value_express的id查value值
     * @return
     */

    //获取自定义变量，对应的数据类型id
    @Override
    public List<RiskBusinessFieldsPO> findAllBusinessFields() {
        return RedisSourcePOMapper.findAllBusinessFields();
    }

    //数据类型（自定义变量，常量）
    @Override
    public List<RiskValueTypePO> findAllValueExpress() {
        return RedisSourcePOMapper.findAllValueExpress();
    }

    //更新token信息,根据id
    @Override
    public int update_token(String id,String token){
        return RedisSourcePOMapper.update_token(id,token);
    }

    /**
     * 返回模型
     * @param input_modelid 模型id
     * @return
     */
    public RiskModelPO return_Model(String input_modelid){
        RiskModelPO new_modelpo=new RiskModelPO();

        List<RiskModelPO> modellist = findAllModel();
        for(RiskModelPO modelPO:modellist) {
            String modelid = modelPO.getId();   //模型id
            String groupruleid = modelPO.getGroupruleid();
            if( !(modelid==null) && !(groupruleid==null) && (input_modelid.equals(modelid)) ){
                new_modelpo=modelPO;
                break;
            }
        }
        return new_modelpo;
    }

    /**
     * 返回规则组
     * @param rulegroupid  规则组id
     * @return
     */
    public RiskGrouprulePO return_Grouprule(String rulegroupid){
        RiskGrouprulePO new_grouprule=new RiskGrouprulePO();

        List<RiskGrouprulePO> grouprulelist = findAllGroup();
        for(RiskGrouprulePO grouprulePO:grouprulelist) {
            String groupid = grouprulePO.getId();  //规则组id
            if(rulegroupid.equals(groupid)){
                new_grouprule=grouprulePO;
                break;
            }
        }
        return new_grouprule;
    }

    /**
     * 返回规则组下的所有规则
     * @param rulegroupid
     * @return
     */
    public List<RiskRulePO> returnaAllrule(String rulegroupid){
        List<RiskRulePO> group_rule = new ArrayList<RiskRulePO>();

        List<RiskGroupruleDetailPO> groupruleDetail = findAllGroupruleDetail();
        List<RiskRulePO> rulelist = findAllRule();  //规则

        for(RiskGroupruleDetailPO groupruleDetailPO:groupruleDetail) {
            //规则组下的规则列表
            String pgroupruleId = groupruleDetailPO.getGroupruleid();  //规则组id
            String ruleId = groupruleDetailPO.getRuleid();  //规则id
                if( !(pgroupruleId==null) && pgroupruleId.equals(rulegroupid) && !(ruleId==null) ){
                    for(RiskRulePO rulePO:rulelist){
                        String rid = rulePO.getId();  //规则id
                        if(ruleId.equals(rid)){
                            group_rule.add(rulePO);
                        }
                    }
                }
            }
        return group_rule;
    }

    /**
     * 根据规则id拿取规则对应的数元，常量，或自定义变量信息
     * @param ruleid
     * @return
     */
    public RiskRulePO getruleformation(String ruleid) {
        RiskRulePO ruleinfo = new RiskRulePO();

        //规则对应的数元信息
        List<RiskElementPO> rule_elements = new ArrayList<RiskElementPO>();

        List<RiskElementPO> elementlist = findAllElement();  //数元列表
        List<RiskRulePO> rulelist = findAllRule();  //规则列表
        //计算表达式表
        List<RiskCalcExpressPO> CalcExpresslist = findAllCalcExpress();
        Map<String, RiskCalcExpressPO> CalcExpress_map = new HashMap<String, RiskCalcExpressPO>();
        for (RiskCalcExpressPO calcExpress : CalcExpresslist) {
            String calid = calcExpress.getId();
            CalcExpress_map.put(calid, calcExpress);
        }
        //用户自定义变量
        List<RiskBusinessFieldsPO> businessFieldlist = findAllBusinessFields();
        //(自定义变量，常量)值数据类型
        List<RiskValueTypePO> valueExpresslist = findAllValueExpress();
        Map<String, RiskValueTypePO> valueExpress_map = new HashMap<String, RiskValueTypePO>();
        for (RiskValueTypePO valueExpress : valueExpresslist) {
            String vid = valueExpress.getId();
            valueExpress_map.put(vid, valueExpress);
        }

        for (RiskRulePO rulePO : rulelist) {
            String rid = rulePO.getId();  //规则id
            if (!(rid == null) && rid.equals(ruleid)) {
                //规则左边类型id
                String leftelemettypeid = rulePO.getLeftelemettypeid();
                //规则左边id
                String leftelementid = rulePO.getLeftelementid();
                //规则包含计算表达式id
                String calcexpressid = rulePO.getCalcexpressid();
                if (!(calcexpressid == null)) {
                    RiskCalcExpressPO calcEx = CalcExpress_map.get(calcexpressid);
                    rulePO.setCalcExpress(calcEx);
                }
                //规则右边类型id
                String rightelementtypeid = rulePO.getRightelementtypeid();
                //规则右边id
                String rightelementid = rulePO.getRightelementid();
                //常量值的类型id
                String valueexpresstypeid = rulePO.getValueexpresstypeid();

                //--------左边判断--------------------------------------------------------
                if (leftelemettypeid.equals("ET002") && !(leftelementid == null)) { //自定义变量
                    for (RiskBusinessFieldsPO businessField : businessFieldlist) {
                        String bid = businessField.getId();
                        String datatypeid = businessField.getDatatypeid();
                        if (!(bid == null) && !(datatypeid == null) && leftelementid.equals(bid)) {
                            RiskValueTypePO upress = valueExpress_map.get(String.valueOf(datatypeid));
                            rulePO.setU_Express_type(upress);
                        }
                    }
                } else if (leftelemettypeid.equals("ET001") && !(leftelementid == null)) {  //系统提供数元
                    for (RiskElementPO element : elementlist) {
                        String el_id = element.getId();
                        if (el_id.equals(leftelementid)) {
                            rule_elements.add(element);
                            break;
                        }
                    }
                } else if (leftelemettypeid.equals("ET003")) { //常量
                    if (!(valueexpresstypeid == null)) {
                        RiskValueTypePO vpress = valueExpress_map.get(String.valueOf(valueexpresstypeid));
                        rulePO.setV_Express_type(vpress);
                    }
                }

                //--------右边判断------！！！
                if (rightelementtypeid.equals("ET002") && !(rightelementid == null)) {  //自定义变量
                    for (RiskBusinessFieldsPO businessField : businessFieldlist) {
                        String bid = businessField.getId();
                        String datatypeid = businessField.getDatatypeid();
                        if (!(bid == null) && !(datatypeid == null) && rightelementid.equals(bid)) {
                            RiskValueTypePO upress = valueExpress_map.get(String.valueOf(datatypeid));
                            rulePO.setU_Express_type(upress);
                        }
                    }
                } else if (rightelementtypeid.equals("ET001") && !(rightelementid == null)) { //系统提供数元
                    for (RiskElementPO element : elementlist) {
                        String el_id = element.getId();
                        if (el_id.equals(rightelementid)) {
                            rule_elements.add(element);
                            break;
                        }
                    }

                } else if (rightelementtypeid.equals("ET003")) { //常量
                    if (!(valueexpresstypeid == null)) {
                        RiskValueTypePO vpress = valueExpress_map.get(String.valueOf(valueexpresstypeid));
                        rulePO.setV_Express_type(vpress);
                    }
                }
                ruleinfo=rulePO;
                ruleinfo.setRule_elements(rule_elements);
                break;
            }

        }
        return ruleinfo;
    }

    /**
     * 根据数元id拿原子信息
     * @param eid
     * @return
     */
    public List<RiskAtomPO>  getatominfor(String eid){
        List<RiskAtomPO> atomlist = new ArrayList<RiskAtomPO>();

        List<RiskElementDetailPO> elementDetaillist = findAllElementDetail();  //数元-原子中间表
        List<RiskAtomPO> allatom = findAllAtom();  //原子列表
        for(RiskElementDetailPO elementDetail:elementDetaillist) {
            String ed_atomid = elementDetail.getAtomid(); //原子id
            String ed_elementid = elementDetail.getElementid();
            if(eid.equals(ed_elementid)){
                for(RiskAtomPO atom:allatom) {
                    String a_id = atom.getId();
                    if (!(a_id == null) && a_id.equals(ed_atomid)) {
                        atomlist.add(atom);
                        break;
                    }
                }
            }
        }
        return atomlist;
    }

    /**
     * 根据原子id，规则id返回相关信息
     * @param atom_id
     * @param in_ruleid
     * @return
     */
    public RiskAtomPO getatominformation(String atom_id,String in_ruleid){
       RiskAtomPO atomPOfinal = new RiskAtomPO();

       List<RiskAtomPO> atomlist = findAllAtom();  //原子
       List<RiskAtomInputParamsPO> atomInputParamlist = findAllAtomInputParams(); //原子输入参数
       List<RiskAtomInputParamBindBusinessfieldidPO> atomInputParamBindBusinessfieldidlist = findAllAtomInputParamBindBusinessfieldid();  //原子输入参数关联表
       List<RiskUrlVersionPO> urlVersionlist = findAllUrlVersionPO();  //url各组成部分
       List<RiskAtomOutputParamsPO> atomOutputParamlist = findAllAtomOutputParams();  //原子输出参数

       for(RiskAtomPO atom:atomlist){
           String a_id = atom.getId();
           if( !(a_id==null) && a_id.equals(atom_id) ){

               //原子输入参数
               List<RiskAtomInputParamsPO> atomInputParam_list = new ArrayList<RiskAtomInputParamsPO>();
               for(RiskAtomInputParamsPO atomInputParam:atomInputParamlist){
                   String in_atomid = atomInputParam.getAtomid();
                   if( !(in_atomid==null) && in_atomid.equals(a_id) ){
                       String inputParamId = atomInputParam.getInputParamId(); //每个原子对应多个个输入标识，该标识下对应唯一businessid

                       //对应唯一business记录
                       RiskAtomInputParamBindBusinessfieldidPO  Businessfield= new RiskAtomInputParamBindBusinessfieldidPO();
                       //通过inputParamId 关联risk_atom_input_param_bind_businessfieldid表的atominputparamid 关联出businessfieldid
                       for(RiskAtomInputParamBindBusinessfieldidPO input:atomInputParamBindBusinessfieldidlist){
                           String atominputparamid = input.getAtominputparamid();
                           String ruleid = input.getRuleId();
                           if( !(atominputparamid==null) && !(ruleid==null) && atominputparamid.equals(inputParamId) && ruleid.equals(in_ruleid) ){  //哪个原子哪个规则下的businessid
                               Businessfield=input;
                               atomInputParam.setInputParamBindBusinessfield(Businessfield);
                               break;
                           }
                       }
                       atomInputParam_list.add(atomInputParam);
                   }

               }
               atom.setAtomInputParams(atomInputParam_list);

               //原子输出参数
               List<RiskAtomOutputParamsPO> output_list = new ArrayList<RiskAtomOutputParamsPO>();
               for(RiskAtomOutputParamsPO atomOutputParam:atomOutputParamlist){
                   String out_atomid = atomOutputParam.getAtomid();
                   if(!(out_atomid==null) && out_atomid.equals(a_id) ){
                       output_list.add(atomOutputParam);
                   }
               }

               //根据id找出url各部分拼接url
               String behindid = atom.getUrlVersionId();
               String part_url = atom.getFuncuri();
               String full_url="";
               for(RiskUrlVersionPO urlVersion:urlVersionlist){
                   String vid = urlVersion.getId();
                   if(vid.equals(behindid)){
                       //
                       String protocol=urlVersion.getProtocol();
                       String ip=urlVersion.getIp();
                       String port=urlVersion.getPort();
                       String version=urlVersion.getVersion();
                       String token=urlVersion.getToken();
                       String accountId=urlVersion.getAccountId();
                       //赋值（token,accountId）
                       atom.setAccountId(accountId);
                       atom.setToken(token);
                       //https://www.baidu.com/   http://192.168.0.181:8080/api/redis/data/all/
                       full_url=protocol+"://"+ip+":"+port+"/"+version+"/"+part_url;
                       atom.setFuncuri(full_url);
                       break;
                   }
               }

               atom.setAtomOutputParams(output_list);
               atomPOfinal=atom;
               break;
           }
           //
       }
       return atomPOfinal;
    }

    /**
     * 封装返回所有信息
     * @param input_modelid
     * @return
     */
    @Override
    public RiskModelPO getResoultPo(String input_modelid) {
        //getatominformation("A000010","R000004"); 原子
        RiskModelPO ModelPO =return_Model(input_modelid); //获取模型
          String groupid = ModelPO.getGroupruleid();
          RiskGrouprulePO Grouprule = return_Grouprule(groupid); //获取规则组

          //获取所有规则
          List<RiskRulePO>  rulelist = returnaAllrule(groupid);//规则单一信息
          List<RiskRulePO>  rulelist_finall = new ArrayList<RiskRulePO>(); //获取规则详细信息
          for(RiskRulePO rule:rulelist){
              String ruleid = rule.getId();

              rule=getruleformation(ruleid); //（包含规则下所有数元）

              List<RiskElementPO> rule_elements = rule.getRule_elements();   //数元单一信息
              List<RiskElementPO> rule_elements_final = new ArrayList<RiskElementPO>();   //数元详细信息
              for(RiskElementPO element:rule_elements){
                  String eid =element.getId() ;

                  List<RiskAtomPO>  atoms = getatominfor(eid); //获取原子单一信息
                  List<RiskAtomPO>  atoms_final = new ArrayList<RiskAtomPO>(); //获取原子详细信息
                  //原子id，规则id返回相关信息
                  for (RiskAtomPO atom:atoms){
                      String aid = atom.getId();
                      RiskAtomPO  ful_atom = getatominformation(aid,ruleid);
                      //ful_atom.setForeign_ruleId(ruleid);  原子外键不需要

                      atoms_final.add(ful_atom);
                  }

                  element.setAtoms(atoms_final);
                  //element.setForeign_ruleId(ruleid);  数元外键不需要
                  rule_elements_final.add(element);
              }

              rulelist_finall.add(rule);
          }

        Grouprule.setGroup_rules(rulelist_finall);
        ModelPO.setModel_ruleGroup(Grouprule);
        return ModelPO;
    }

    //序列化
    public static byte [] serialize(Object obj){
        ObjectOutputStream obi=null;
        ByteArrayOutputStream bai=null;
        try {
            bai=new ByteArrayOutputStream();
            obi=new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt=bai.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //反序列化
    public static Object unserizlize(byte[] byt){
        ObjectInputStream oii=null;
        ByteArrayInputStream bis=null;
        bis=new ByteArrayInputStream(byt);
        try {
            oii=new ObjectInputStream(bis);
            Object obj=oii.readObject();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //---------------------------------------------------往redis中存入数据-----------------------------------------------------------------------------------------

    //根据模型id获取各部分数据插入redis ---全量数据
    @Override
    public void insert_redis_start(String input_modelid){
        RiskModelPO model = getResoultPo(input_modelid);
        insert_model(model);  //模型入库

        RiskGrouprulePO  grouprule = model.getModel_ruleGroup();
        String gid = grouprule.getId();
        insert_rulegroup(grouprule);  //规则组入库

        List<RiskRulePO> group_rules = grouprule.getGroup_rules();
        for(RiskRulePO rule:group_rules){
            String rid = rule.getId();
            insert_rule(rule); //规则入库

            List<RiskElementPO> rule_elements = rule.getRule_elements();
             for(RiskElementPO  element:rule_elements){
                 String eid = element.getId();
                 insert_element(element);  //数元入库

                 List<RiskAtomPO> atoms = element.getAtoms();
                 for(RiskAtomPO atom:atoms){
                     String  aid = atom.getId();
                     String akey="a:"+input_modelid+":"+gid+":"+rid+":"+eid+":"+aid;
                     insert_atom(akey,atom); //原子入库

                 }
             }
        }
    }

    //插入流水表中所有数据 ---全量数据
    @Override
    public void insert_redis_allbusiness(){
        List<RiskCallingDetailPO> callingDetail_list = findAllCallingDetail();
        for(RiskCallingDetailPO  callingDetail:callingDetail_list){
            insert_businessValue(callingDetail);
        }
    }



    //---------------------------------------------------------------------------------------------单个实体操作
    //插入流水表中输入参数数据businessValue
    @Override
    public void insert_businessValue(RiskCallingDetailPO callingDetailPO){
        //HMSET  “c:流水号id:businessid”
        redis.connect();
        //存储数据
        String seqid = callingDetailPO.getSeqid();
        String businessid = callingDetailPO.getBusinessid();
        String ckey = "c:"+seqid+":"+businessid;
        redis.set(ckey.getBytes(), serialize(callingDetailPO));
        redis.disconnect();
    }
    //获取流水表输入参数数据
    @Override
    public RiskCallingDetailPO get_businessValue(String key){
        RiskCallingDetailPO callingDetail = null;
        redis.connect();
        //获取数据
        byte[] byt=redis.get(key.getBytes());
        if( !(byt==null) && byt.length>0 ){
            callingDetail = new RiskCallingDetailPO();
            Object obj=unserizlize(byt);
            if(obj instanceof RiskCallingDetailPO){
                callingDetail=(RiskCallingDetailPO)obj ;
                //System.out.println(atom.toString());
            }
        }
        redis.disconnect();
        return callingDetail;
    }


    //插入宽表(根据id直接查询原子信息，最小粒度)
    @Override
    public void insert_atom(String akey,RiskAtomPO atom){
        //HMSET  “a:模型id:规则组id:规则id:数元id:原子id”
        redis.connect();
        //存储数据
        redis.set(akey.getBytes(), serialize(atom));
        redis.disconnect();
    }
    //获取原子
    @Override
    public RiskAtomPO get_atom(String key){
        RiskAtomPO atom = null;
        redis.connect();
        //获取数据
        byte[] byt=redis.get(key.getBytes());
        if( !(byt==null) && byt.length>0 ) {
            atom = new RiskAtomPO();
            Object obj = unserizlize(byt);
            if (obj instanceof RiskAtomPO) {
                atom = (RiskAtomPO) obj;
                //System.out.println(atom.toString());
            }
        }
        redis.disconnect();
        return atom;
    }

    //插入模型
    @Override
    public void insert_model(RiskModelPO riskModelPO){
        //HMSET  “m:模型id”
        redis.connect();
        //存储数据
        String modelid = riskModelPO.getId();
        String model_key = "m:"+modelid;
        redis.set(model_key.getBytes(), serialize(riskModelPO));
        redis.disconnect();
    }
    //获取模型
    @Override
    public RiskModelPO get_model(String key){
        RiskModelPO model = null;
        redis.connect();
        //获取数据
        byte[] byt=redis.get(key.getBytes());
        if( !(byt==null) && byt.length>0 ) {
            model = new RiskModelPO();
            Object obj = unserizlize(byt);
            if (obj instanceof RiskModelPO) {
                model = (RiskModelPO) obj;
                //System.out.println(model.toString());
            }
        }
        redis.disconnect();
        return model;
    }

    //插入规则组
    @Override
    public void insert_rulegroup(RiskGrouprulePO  grouprule){
        //HMSET  “g:规则组id”
        redis.connect();
        //存储数据
        String key= "g:"+grouprule.getId();
        redis.set(key.getBytes(), serialize(grouprule));
        redis.disconnect();
    }
    //获取规则组
    @Override
    public RiskGrouprulePO get_rulegroup(String key){
        RiskGrouprulePO grouprule = null;
        redis.connect();
        //获取数据
        byte[] byt=redis.get(key.getBytes());
        if( !(byt==null) && byt.length>0 ) {
            grouprule = new RiskGrouprulePO();
            Object obj = unserizlize(byt);
            if (obj instanceof RiskGrouprulePO) {
                grouprule = (RiskGrouprulePO) obj;
                //System.out.println(grouprule.toString());
            }
        }
        redis.disconnect();
        return grouprule;
    }

    //插入规则
    @Override
    public void insert_rule(RiskRulePO RiskRulePO){
        //HMSET  “r:规则id”
        redis.connect();
        //存储数据
        String key="r:"+RiskRulePO.getId();
        redis.set(key.getBytes(), serialize(RiskRulePO));
        redis.disconnect();
    }
    //获取规则
    @Override
    public RiskRulePO get_rule(String key){
        RiskRulePO rule = null;
        redis.connect();
        //获取数据
        byte[] byt=redis.get(key.getBytes());
        if( !(byt==null) && byt.length>0 ) {
            rule = new RiskRulePO();
            Object obj = unserizlize(byt);
            if (obj instanceof RiskRulePO) {
                rule = (RiskRulePO) obj;
                //System.out.println(rule.toString());
            }
        }
        redis.disconnect();
        return rule;
    }

    //插入数元
    @Override
    public void insert_element(RiskElementPO riskElement){
        //HMSET  “e:数元id”
        redis.connect();
        //存储数据
        String key="e:"+riskElement.getId();
        redis.set(key.getBytes(), serialize(riskElement));
        redis.disconnect();
    }
    //获取数元
    @Override
    public RiskElementPO get_element(String key){
        RiskElementPO  element = null;
        redis.connect();
        //获取数据
        byte[] byt=redis.get(key.getBytes());
        if( !(byt==null) && byt.length>0 ) {
            element = new RiskElementPO();
            Object obj = unserizlize(byt);
            if (obj instanceof RiskElementPO) {
                element = (RiskElementPO) obj;
                //System.out.println(element.toString());
            }
        }
        redis.disconnect();
        return element;
    }


    //------------------------------------------------------------------------------------------------------------------------------------------------------------
}

