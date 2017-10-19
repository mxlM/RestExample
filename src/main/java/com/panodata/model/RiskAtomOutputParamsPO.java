package com.panodata.model;

import java.io.Serializable;

public class RiskAtomOutputParamsPO implements Serializable {
    private String atomid;

    private String paramname;

    private String paramtype;

    private String paramformat;

    private String description;

    private static final long serialVersionUID = 1L;

    public RiskAtomOutputParamsPO() {}
    public RiskAtomOutputParamsPO(String atomid, String paramname, String paramtype, String paramformat, String description) {
        this.atomid = atomid;
        this.paramname = paramname;
        this.paramtype = paramtype;
        this.paramformat = paramformat;
        this.description = description;
    }
    @Override
    public String toString() {
        return "RiskAtomOutputParamsPO{" +
                "atomid='" + atomid + '\'' +
                ", paramname='" + paramname + '\'' +
                ", paramtype='" + paramtype + '\'' +
                ", paramformat='" + paramformat + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getAtomid() {
        return atomid;
    }

    public void setAtomid(String atomid) {
        this.atomid = atomid == null ? "" : atomid.trim();
    }

    public String getParamname() {
        return paramname;
    }

    public void setParamname(String paramname) {
        this.paramname = paramname == null ? "" : paramname.trim();
    }

    public String getParamtype() {
        return paramtype;
    }

    public void setParamtype(String paramtype) {
        this.paramtype = paramtype == null ? "" : paramtype.trim();
    }

    public String getParamformat() {
        return paramformat;
    }

    public void setParamformat(String paramformat) {
        this.paramformat = paramformat == null ? "" : paramformat.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? "" : description.trim();
    }
}