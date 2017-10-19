package com.panodata.model;

import java.io.Serializable;

public class RiskGroupruleDetailPO implements Serializable {
    private String groupruleid;

    private String ruleid;

    private Integer seqid;

    private static final long serialVersionUID = 1L;

    public String getGroupruleid() {
        return groupruleid;
    }

    public void setGroupruleid(String groupruleid) {
        this.groupruleid = groupruleid == null ? "" : groupruleid.trim();
    }

    public String getRuleid() {
        return ruleid;
    }

    public void setRuleid(String ruleid) {
        this.ruleid = ruleid == null ? "" : ruleid.trim();
    }

    public Integer getSeqid() {
        return seqid;
    }

    public void setSeqid(Integer seqid) {
        this.seqid = seqid == null ? 0 : seqid;
    }
}