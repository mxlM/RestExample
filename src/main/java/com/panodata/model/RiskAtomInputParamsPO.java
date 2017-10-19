package com.panodata.model;

import java.io.Serializable;
import java.util.List;

public class RiskAtomInputParamsPO implements Serializable {
    private String atomid;

   // private String businessfieldid;  改为从输入参数中间表拿取

    private String description;

    private String keyname;

    private String keytypeid;

    private String inputParamId; //每个原子输入唯一标识  通过该值关联risk_atom_input_param_bind_businessfieldid表的atominputparamid 关联出businessfieldid
    public String getInputParamId() {
        return inputParamId;
    }
    public void setInputParamId(String inputParamId) {
        this.inputParamId = inputParamId == null ? "" : inputParamId;
    }

/*    private String foreign_ruleId;  //外键属于哪个规则id
    public String getForeign_ruleId() {
        return foreign_ruleId;
    }
    public void setForeign_ruleId(String foreign_ruleId) {
        this.foreign_ruleId = foreign_ruleId == null ? null : foreign_ruleId;
    }*/


    private static final long serialVersionUID = 1L;

    public RiskAtomInputParamsPO() {}
    public RiskAtomInputParamsPO(String atomid, String description, String keyname, String keytypeid, String inputParamId, RiskAtomInputParamBindBusinessfieldidPO inputParamBindBusinessfield) {
        this.atomid = atomid;
        this.description = description;
        this.keyname = keyname;
        this.keytypeid = keytypeid;
        this.inputParamId = inputParamId;
        this.inputParamBindBusinessfield = inputParamBindBusinessfield;
    }

    @Override
    public String toString() {
        return "RiskAtomInputParamsPO{" +
                "atomid='" + atomid + '\'' +
                ", description='" + description + '\'' +
                ", keyname='" + keyname + '\'' +
                ", keytypeid='" + keytypeid + '\'' +
                ", inputParamId='" + inputParamId + '\'' +
                ", inputParamBindBusinessfield=" + inputParamBindBusinessfield +
                '}';
    }

    //输入参数的唯一标识inputParamId对应唯一business记录
    private RiskAtomInputParamBindBusinessfieldidPO  inputParamBindBusinessfield;
    public RiskAtomInputParamBindBusinessfieldidPO getInputParamBindBusinessfield() {
        return inputParamBindBusinessfield;
    }
    public void setInputParamBindBusinessfield(RiskAtomInputParamBindBusinessfieldidPO inputParamBindBusinessfield) {
        this.inputParamBindBusinessfield = inputParamBindBusinessfield == null ? null : inputParamBindBusinessfield;
    }

    //-------------------------------------------------------------------------------------------
/*    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if((obj == null) || (obj.getClass() != this.getClass()))
            return false;
        RiskAtomInputParamsPO test = (RiskAtomInputParamsPO)obj;

        boolean cheak=true;

        List<RiskAtomInputParamBindBusinessfieldidPO> test_business_list = test.getInputParamBindBusinessfield();
        List<RiskAtomInputParamBindBusinessfieldidPO> this_business_list = this.getInputParamBindBusinessfield();
        for(RiskAtomInputParamBindBusinessfieldidPO test_business:test_business_list){
            for(RiskAtomInputParamBindBusinessfieldidPO this_business:this_business_list){
                if( !(this_business.getBusinessfieldid().equals(test_business.getBusinessfieldid())) && !(this_business.getRuleId().equals(test_business.getRuleId())) ) {  //businessid 和 ruleid不相等
                    cheak=false;
                    break;
                }
            }
        }
        return atomid.equals(test.atomid)  //比较原子id
                && cheak;
    }

    public int hashCode()
    {
        int hash1 = 7;
        int hash2 = 31 * hash1 + atomid.hashCode();
        int hash3 = 31 * hash2 + (null == foreign_ruleId ? 0 : foreign_ruleId.hashCode());
        return hash3;
    }*/
    //-----------------------------------------------------------------------------------------------------

    public String getAtomid() {
        return atomid;
    }

    public void setAtomid(String atomid) {
        this.atomid = atomid == null ? "" : atomid.trim();
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? "" : description.trim();
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname == null ? "" : keyname.trim();
    }

    public String getKeytypeid() {
        return keytypeid;
    }

    public void setKeytypeid(String keytypeid) {
        this.keytypeid = keytypeid == null ? "" : keytypeid.trim();
    }
}