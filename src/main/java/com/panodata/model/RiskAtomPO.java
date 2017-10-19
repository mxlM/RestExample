package com.panodata.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class RiskAtomPO implements Serializable {
    private String id;

    private String discription;

    private String atomvaluetypeid;

    private String funcuri;

    private String funcmethod;

    private String funcheader;

    private String funcexpress;

    private String status;

    private String token;  //需要赋值

    private String accountId;  //需要赋值

    private static final long serialVersionUID = 1L;

    public RiskAtomPO() {}
    public RiskAtomPO(String id, String discription, String atomvaluetypeid, String funcuri, String funcmethod, String funcheader, String funcexpress, String status, String token, String accountId, String urlVersionId, List<RiskAtomInputParamsPO> atomInputParams, List<RiskAtomOutputParamsPO> atomOutputParams) {
        this.id = id;
        this.discription = discription;
        this.atomvaluetypeid = atomvaluetypeid;
        this.funcuri = funcuri;
        this.funcmethod = funcmethod;
        this.funcheader = funcheader;
        this.funcexpress = funcexpress;
        this.status = status;
        this.token = token;
        this.accountId = accountId;
        this.urlVersionId = urlVersionId;
        this.atomInputParams = atomInputParams;
        this.atomOutputParams = atomOutputParams;
    }

    @Override
    public String toString() {
        return "RiskAtomPO{" +
                "id='" + id + '\'' +
                ", discription='" + discription + '\'' +
                ", atomvaluetypeid='" + atomvaluetypeid + '\'' +
                ", funcuri='" + funcuri + '\'' +
                ", funcmethod='" + funcmethod + '\'' +
                ", funcheader='" + funcheader + '\'' +
                ", funcexpress='" + funcexpress + '\'' +
                ", status='" + status + '\'' +
                ", token='" + token + '\'' +
                ", accountId='" + accountId + '\'' +
                ", urlVersionId='" + urlVersionId + '\'' +
                ", atomInputParams=" + atomInputParams +
                ", atomOutputParams=" + atomOutputParams +
                '}';
    }
    /*    private String foreign_ruleId;  //外键属于哪个规则id
    public String getForeign_ruleId() {
        return foreign_ruleId;
    }
    public void setForeign_ruleId(String foreign_ruleId) {
        this.foreign_ruleId = foreign_ruleId == null ? null : foreign_ruleId;
    }*/

    private String urlVersionId;
    public String getUrlVersionId() {
        return urlVersionId;
    }
    public void setUrlVersionId(String urlVersionId) {
        this.urlVersionId = urlVersionId == null ? "" :urlVersionId;
    }

    private List<RiskAtomInputParamsPO> atomInputParams;  //原子输入参数  包含唯一标识inputParamId的一条记录
    private List<RiskAtomOutputParamsPO>  atomOutputParams;  //原子输出参数

    public List<RiskAtomInputParamsPO> getAtomInputParams() {
        return atomInputParams;
    }
    public void setAtomInputParams(List<RiskAtomInputParamsPO> atomInputParams) {
        this.atomInputParams = atomInputParams == null ? null :atomInputParams;
    }

    public List<RiskAtomOutputParamsPO> getAtomOutputParams() {
        return atomOutputParams;
    }
    public void setAtomOutputParams(List<RiskAtomOutputParamsPO> atomOutputParams) {
        this.atomOutputParams = atomOutputParams == null ? null :atomOutputParams;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? "" : id.trim();
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription == null ? "" : discription.trim();
    }

    public String getAtomvaluetypeid() {
        return atomvaluetypeid;
    }

    public void setAtomvaluetypeid(String atomvaluetypeid) {
        this.atomvaluetypeid = atomvaluetypeid == null ? "" : atomvaluetypeid.trim();
    }

    public String getFuncuri() {
        return funcuri;
    }

    public void setFuncuri(String funcuri) {
        this.funcuri = funcuri == null ? "" : funcuri.trim();
    }

    public String getFuncmethod() {
        return funcmethod;
    }

    public void setFuncmethod(String funcmethod) {
        this.funcmethod = funcmethod == null ? "" : funcmethod.trim();
    }

    public String getFuncheader() {
        return funcheader;
    }

    public void setFuncheader(String funcheader) {
        this.funcheader = funcheader == null ? "" : funcheader.trim();
    }

    public String getFuncexpress() {
        return funcexpress;
    }

    public void setFuncexpress(String funcexpress) {
        this.funcexpress = funcexpress == null ? "" : funcexpress.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? "" : status.trim();
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token == null ? "" : token.trim();
    }

    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? "" : accountId.trim();
    }
}