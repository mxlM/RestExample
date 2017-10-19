package com.panodata.model;

import java.io.Serializable;
import java.util.List;

public class RiskRulePO implements Serializable {
    private String id;

    private String leftelemettypeid;

    private String leftelementid;

    private String calcexpressid;

    private String rightelementtypeid;

    private String rightelementid;

    private String calcexpressvalue;

    private String valueexpresstypeid;

    private String description;

    private String createtime;

    private String status;

    public RiskRulePO() {}
    public RiskRulePO(String id, String leftelemettypeid, String leftelementid, String calcexpressid, String rightelementtypeid, String rightelementid, String calcexpressvalue, String valueexpresstypeid, String description, String createtime, String status, List<RiskElementPO> rule_elements, RiskValueTypePO v_Express_type, RiskValueTypePO u_Express_type, RiskCalcExpressPO calcExpress) {
        this.id = id;
        this.leftelemettypeid = leftelemettypeid;
        this.leftelementid = leftelementid;
        this.calcexpressid = calcexpressid;
        this.rightelementtypeid = rightelementtypeid;
        this.rightelementid = rightelementid;
        this.calcexpressvalue = calcexpressvalue;
        this.valueexpresstypeid = valueexpresstypeid;
        this.description = description;
        this.createtime = createtime;
        this.status = status;
        this.rule_elements = rule_elements;
        this.v_Express_type = v_Express_type;
        this.u_Express_type = u_Express_type;
        this.calcExpress = calcExpress;
    }
    @Override
    public String toString() {
        return "RiskRulePO{" +
                "id='" + id + '\'' +
                ", leftelemettypeid='" + leftelemettypeid + '\'' +
                ", leftelementid='" + leftelementid + '\'' +
                ", calcexpressid='" + calcexpressid + '\'' +
                ", rightelementtypeid='" + rightelementtypeid + '\'' +
                ", rightelementid='" + rightelementid + '\'' +
                ", calcexpressvalue='" + calcexpressvalue + '\'' +
                ", valueexpresstypeid='" + valueexpresstypeid + '\'' +
                ", description='" + description + '\'' +
                ", createtime='" + createtime + '\'' +
                ", status='" + status + '\'' +
                ", rule_elements=" + rule_elements +
                ", v_Express_type=" + v_Express_type +
                ", u_Express_type=" + u_Express_type +
                ", calcExpress=" + calcExpress +
                '}';
    }

    //一个规则对应多个数元
    private List<RiskElementPO> rule_elements;
    public List<RiskElementPO> getRule_elements() {
        return rule_elements;
    }
    public void setRule_elements(List<RiskElementPO> rule_elements) {
        this.rule_elements = rule_elements == null ? null :rule_elements;
    }

    private static final long serialVersionUID = 1L;

    private RiskValueTypePO  v_Express_type; //常量值数据类型
    public RiskValueTypePO getV_Express_type() {
        return v_Express_type;
    }
    public void setV_Express_type(RiskValueTypePO v_Express_type) {
        this.v_Express_type = v_Express_type == null ? null : v_Express_type;
    }

    private RiskValueTypePO  u_Express_type; //自定义变量值数据类型
    public RiskValueTypePO getU_Express_type() {
        return u_Express_type;
    }
    public void setU_Express_type(RiskValueTypePO u_Express_type) {
        this.u_Express_type = u_Express_type == null ? null : u_Express_type;
    }

    private RiskCalcExpressPO calcExpress; //计算表达式表
    public RiskCalcExpressPO getCalcExpress() {
        return calcExpress;
    }
    public void setCalcExpress(RiskCalcExpressPO calcExpress) {
        this.calcExpress = calcExpress == null ? null : calcExpress;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? "" : id.trim();
    }

    public String getLeftelemettypeid() {
        return leftelemettypeid;
    }

    public void setLeftelemettypeid(String leftelemettypeid) {
        this.leftelemettypeid = leftelemettypeid == null ? "" : leftelemettypeid.trim();
    }

    public String getLeftelementid() {
        return leftelementid;
    }

    public void setLeftelementid(String leftelementid) {
        this.leftelementid = leftelementid == null ? "" : leftelementid.trim();
    }

    public String getCalcexpressid() {
        return calcexpressid;
    }

    public void setCalcexpressid(String calcexpressid) {
        this.calcexpressid = calcexpressid == null ? "" : calcexpressid.trim();
    }

    public String getRightelementtypeid() {
        return rightelementtypeid;
    }

    public void setRightelementtypeid(String rightelementtypeid) {
        this.rightelementtypeid = rightelementtypeid == null ? "" : rightelementtypeid.trim();
    }

    public String getRightelementid() {
        return rightelementid;
    }

    public void setRightelementid(String rightelementid) {
        this.rightelementid = rightelementid == null ? "" : rightelementid.trim();
    }

    public String getCalcexpressvalue() {
        return calcexpressvalue;
    }

    public void setCalcexpressvalue(String calcexpressvalue) {
        this.calcexpressvalue = calcexpressvalue == null ? "" : calcexpressvalue.trim();
    }

    public String getValueexpresstypeid() {
        return valueexpresstypeid;
    }

    public void setValueexpresstypeid(String valueexpresstypeid) {
        this.valueexpresstypeid = valueexpresstypeid == null ? "" : valueexpresstypeid.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? "" : description.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? "" : createtime.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? "" : status.trim();
    }
}