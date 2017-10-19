package com.panodata.model;

import java.io.Serializable;

public class RiskCallingDetailPO implements Serializable {
    private String seqid;

    private String businessid;

    private String businessvalue;

    private static final long serialVersionUID = 1L;

    public RiskCallingDetailPO() {}
    public RiskCallingDetailPO(String seqid, String businessid, String businessvalue) {
        this.seqid = seqid;
        this.businessid = businessid;
        this.businessvalue = businessvalue;
    }
    @Override
    public String toString() {
        return "RiskCallingDetailPO{" +
                "seqid='" + seqid + '\'' +
                ", businessid='" + businessid + '\'' +
                ", businessvalue='" + businessvalue + '\'' +
                '}';
    }

    public String getSeqid() {
        return seqid;
    }

    public void setSeqid(String seqid) {
        this.seqid = seqid == null ? null : seqid.trim();
    }

    public String getBusinessid() {
        return businessid;
    }

    public void setBusinessid(String businessid) {
        this.businessid = businessid == null ? null : businessid.trim();
    }

    public String getBusinessvalue() {
        return businessvalue;
    }

    public void setBusinessvalue(String businessvalue) {
        this.businessvalue = businessvalue == null ? null : businessvalue.trim();
    }
}