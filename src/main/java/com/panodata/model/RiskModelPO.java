package com.panodata.model;

import java.io.Serializable;
import java.util.List;

public class RiskModelPO implements Serializable {
    private String id;

    private String modelname;

    private String status;

    private String description;

    private String createtime;

    private String owner;

    private String groupruleid;

    public RiskModelPO() {}
    public RiskModelPO(String id, String modelname, String status, String description, String createtime, String owner, String groupruleid, RiskGrouprulePO model_rulegroup) {
        this.id = id;
        this.modelname = modelname;
        this.status = status;
        this.description = description;
        this.createtime = createtime;
        this.owner = owner;
        this.groupruleid = groupruleid;
        this.model_rulegroup = model_rulegroup;
    }
    @Override
    public String toString() {
        return "RiskModelPO{" +
                "id='" + id + '\'' +
                ", modelname='" + modelname + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", createtime='" + createtime + '\'' +
                ", owner='" + owner + '\'' +
                ", groupruleid='" + groupruleid + '\'' +
                ", model_rulegroup=" + model_rulegroup +
                '}';
    }

    private RiskGrouprulePO model_rulegroup ;  //一个模型对应一个规则组
    public RiskGrouprulePO getModel_ruleGroup() {
        return model_rulegroup;
    }
    public void setModel_ruleGroup(RiskGrouprulePO model_ruleGroup) {
        this.model_rulegroup = model_ruleGroup == null ? null :model_ruleGroup;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? "" : id.trim();
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname == null ? "" : modelname.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? "" : status.trim();
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? "" : owner.trim();
    }

    public String getGroupruleid() {
        return groupruleid;
    }

    public void setGroupruleid(String groupruleid) {
        this.groupruleid = groupruleid == null ? "" : groupruleid.trim();
    }
}