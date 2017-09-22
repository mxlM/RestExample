package com.panodata.model;

import java.io.Serializable;

public class AsdasdxPO implements Serializable {
    private String q;

    private String a;

    private static final long serialVersionUID = 1L;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q == null ? null : q.trim();
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a == null ? null : a.trim();
    }
}