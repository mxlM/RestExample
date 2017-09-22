package com.panodata.conf.mongo.model;

/**
 * Created by zongtong on 2017/7/5.
 */
public class PersonDirectly {
    //直亲姓名
    private String directlyName;
    //关系
    private String relation;

    //直亲手机
    private String directlyTel;

    public String getDirectlyName() {
        return directlyName;
    }

    public void setDirectlyName(String directlyName) {
        this.directlyName = directlyName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getDirectlyTel() {
        return directlyTel;
    }

    public void setDirectlyTel(String directlyTel) {
        this.directlyTel = directlyTel;
    }

    @Override
    public String toString() {
        return "PersonDirectly{" +
                "directlyName='" + directlyName + '\'' +
                ", relation='" + relation + '\'' +
                ", directlyTel='" + directlyTel + '\'' +
                '}';
    }
}
