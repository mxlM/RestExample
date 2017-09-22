package com.panodata.conf.mongo.model;

/**
 * Created by zongtong on 2017/7/5.
 */
public class PersonInformation {
    //卡组织
    private String cardOrganization;
    //中文姓名
    private String chinaName;
    //拼音姓名
    private String pinyinName;
    //身份证号
    private String iDNumber;
    //发证机关（省市区）
    private String licence_IssuingAuthority;
    //单位名称
    private String  companyName;
    //单位地址（省市区）
    private String  companyAddress;
    //手机号
    private String  mobileTel;
    //婚姻状况
    private String  maritalStatus;
    //教育程度
    private String  educationalStatus;
    //住宅情况
    private String houseStatus;
    //电子邮箱
    private String email;
    //住宅地址
    private String houseAddress;

    public String getCardOrganization() {
        return cardOrganization;
    }

    public void setCardOrganization(String cardOrganization) {
        this.cardOrganization = cardOrganization;
    }

    public String getChinaName() {
        return chinaName;
    }

    public void setChinaName(String chinaName) {
        this.chinaName = chinaName;
    }

    public String getPinyinName() {
        return pinyinName;
    }

    public void setPinyinName(String pinyinName) {
        this.pinyinName = pinyinName;
    }

    public String getiDNumber() {
        return iDNumber;
    }

    public void setiDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public String getLicence_IssuingAuthority() {
        return licence_IssuingAuthority;
    }

    public void setLicence_IssuingAuthority(String licence_IssuingAuthority) {
        this.licence_IssuingAuthority = licence_IssuingAuthority;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getMobileTel() {
        return mobileTel;
    }

    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEducationalStatus() {
        return educationalStatus;
    }

    public void setEducationalStatus(String educationalStatus) {
        this.educationalStatus = educationalStatus;
    }

    public String getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }
}
