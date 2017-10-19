package com.panodata.model;

import java.io.Serializable;

public class RiskElementDetailPO implements Serializable {
    private String elementid;

    private String atomid;

    private Integer seqid;

    private String foreign_ruleId;  //外键属于哪个规则id
    public String getForeign_ruleId() {
        return foreign_ruleId;
    }
    public void setForeign_ruleId(String foreign_ruleId) {
        this.foreign_ruleId = foreign_ruleId == null ? null : foreign_ruleId;
    }

    private static final long serialVersionUID = 1L;

    public String getElementid() {
        return elementid;
    }

    public void setElementid(String elementid) {
        this.elementid = elementid == null ? "" : elementid.trim();
    }

    public String getAtomid() {
        return atomid;
    }

    public void setAtomid(String atomid) {
        this.atomid = atomid == null ? "" : atomid.trim();
    }

    public Integer getSeqid() {
        return seqid;
    }

    public void setSeqid(Integer seqid) {
        this.seqid = seqid == null ? 0 : seqid;
    }
}