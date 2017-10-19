package com.panodata.model;

import java.io.Serializable;
import java.util.List;

public class RiskGrouprulePO implements Serializable {
    private String id;

    private String logicexpress;

    private String description;

    private String createtime;

    private String status;

    public RiskGrouprulePO() {}
    public RiskGrouprulePO(String id, String logicexpress, String description, String createtime, String status, List<RiskRulePO> group_rules) {
        this.id = id;
        this.logicexpress = logicexpress;
        this.description = description;
        this.createtime = createtime;
        this.status = status;
        this.group_rules = group_rules;
    }
    @Override
    public String toString() {
        return "RiskGrouprulePO{" +
                "id='" + id + '\'' +
                ", logicexpress='" + logicexpress + '\'' +
                ", description='" + description + '\'' +
                ", createtime='" + createtime + '\'' +
                ", status='" + status + '\'' +
                ", group_rules=" + group_rules +
                '}';
    }

    //一个规则组对应多个规则
    private List<RiskRulePO> group_rules;
    public List<RiskRulePO> getGroup_rules() {
        return group_rules;
    }
    public void setGroup_rules(List<RiskRulePO> group_rules) {
        this.group_rules = group_rules == null ? null :group_rules;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? "" : id.trim();
    }

    public String getLogicexpress() {
        return logicexpress;
    }

    public void setLogicexpress(String logicexpress) {
        this.logicexpress = logicexpress == null ? "" : logicexpress.trim();
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