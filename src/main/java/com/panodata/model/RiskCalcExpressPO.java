package com.panodata.model;

import java.io.Serializable;

public class RiskCalcExpressPO implements Serializable {
    private String id;

    private String value;

    private String description;

    private static final long serialVersionUID = 1L;

    public RiskCalcExpressPO() {}
    public RiskCalcExpressPO(String id, String value, String description) {
        this.id = id;
        this.value = value;
        this.description = description;
    }
    @Override
    public String toString() {
        return "RiskCalcExpressPO{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}