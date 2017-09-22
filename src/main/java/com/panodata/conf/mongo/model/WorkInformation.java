package com.panodata.conf.mongo.model;

/**
 * Created by zongtong on 2017/7/5.
 */
public class WorkInformation {
    //work
    //工作名称
    private String jobTitle;
    //单位性质
    private String unitProperties;
    //所属行业
    private String  industryInvolved;
    //职位
    private String job;
    //年收入
    private String yearlySalaries;
    //单位电话
    private String officeTel;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getUnitProperties() {
        return unitProperties;
    }

    public void setUnitProperties(String unitProperties) {
        this.unitProperties = unitProperties;
    }

    public String getIndustryInvolved() {
        return industryInvolved;
    }

    public void setIndustryInvolved(String industryInvolved) {
        this.industryInvolved = industryInvolved;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getYearlySalaries() {
        return yearlySalaries;
    }

    public void setYearlySalaries(String yearlySalaries) {
        this.yearlySalaries = yearlySalaries;
    }

    public String getOfficeTel() {
        return officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    @Override
    public String toString() {
        return "WorkInformation{" +
                "jobTitle='" + jobTitle + '\'' +
                ", unitProperties='" + unitProperties + '\'' +
                ", industryInvolved='" + industryInvolved + '\'' +
                ", job='" + job + '\'' +
                ", yearlySalaries='" + yearlySalaries + '\'' +
                ", officeTel='" + officeTel + '\'' +
                '}';
    }
}
