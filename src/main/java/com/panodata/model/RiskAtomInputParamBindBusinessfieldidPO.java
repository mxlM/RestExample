package com.panodata.model;

/**
 * Created by quyuan on 2017/10/12.
 */

import java.io.Serializable;

public class RiskAtomInputParamBindBusinessfieldidPO implements Serializable {

    private String atominputparamid;

    private String businessfieldid;

    private String ruleId;
    public String getRuleId() {
        return ruleId;
    }
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? "" : ruleId;
    }

    private static final long serialVersionUID = 1L;

    public RiskAtomInputParamBindBusinessfieldidPO() {}
    public RiskAtomInputParamBindBusinessfieldidPO(String atominputparamid, String businessfieldid, String ruleId) {
        this.atominputparamid = atominputparamid;
        this.businessfieldid = businessfieldid;
        this.ruleId = ruleId;
    }
    @Override
    public String toString() {
        return "RiskAtomInputParamBindBusinessfieldidPO{" +
                "atominputparamid='" + atominputparamid + '\'' +
                ", businessfieldid='" + businessfieldid + '\'' +
                ", ruleId='" + ruleId + '\'' +
                '}';
    }

    public String getAtominputparamid() {
        return atominputparamid;
    }

    public void setAtominputparamid(String atominputparamid) {
        this.atominputparamid = atominputparamid == null ? "" : atominputparamid.trim();
    }

    public String getBusinessfieldid() {
        return businessfieldid;
    }

    public void setBusinessfieldid(String businessfieldid) {
        this.businessfieldid = businessfieldid == null ? "" : businessfieldid.trim();
    }
}
