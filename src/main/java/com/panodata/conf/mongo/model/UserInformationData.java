package com.panodata.conf.mongo.model;


import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

public class UserInformationData implements Serializable {
    @Id
    private String id;
    private String name;//姓名
    private String tel;//电话
    private String creditCardName;//电话
    private Date applicationTime;
    private String applicationDate;
    private String channel;
    private String ip;
    private PersonInformation personInformation;//person（个人信息）
    //private CreditCardData creditCardData;//person（个人信息）
    private WorkInformation workInformation;//work(工作信息)
    private PersonDirectly personDirectly; //person 亲人信息

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public PersonInformation getPersonInformation() {
        return personInformation;
    }

    public void setPersonInformation(PersonInformation personInformation) {
        this.personInformation = personInformation;
    }

    public WorkInformation getWorkInformation() {
        return workInformation;
    }

    public void setWorkInformation(WorkInformation workInformation) {
        this.workInformation = workInformation;
    }

    public PersonDirectly getPersonDirectly() {
        return personDirectly;
    }

    public void setPersonDirectly(PersonDirectly personDirectly) {
        this.personDirectly = personDirectly;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

//    public CreditCardData getCreditCardData() {
//        return creditCardData;
//    }

//    public void setCreditCardData(CreditCardData creditCardData) {
//        this.creditCardData = creditCardData;
//    }
}
