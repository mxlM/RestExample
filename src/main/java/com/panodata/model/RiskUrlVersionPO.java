package com.panodata.model;

/**
 * Created by quyuan on 2017/10/12.
 */

import java.io.Serializable;

public class RiskUrlVersionPO implements Serializable {

    private String id;

    private String protocol;

    private String ip;

    private String port;

    private String version;

    private String token;

    private String accountId;

    private static final long serialVersionUID = 1L;

    public RiskUrlVersionPO() {}
    public RiskUrlVersionPO(String id, String protocol, String ip, String port, String version, String token, String accountId) {
        this.id = id;
        this.protocol = protocol;
        this.ip = ip;
        this.port = port;
        this.version = version;
        this.token = token;
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "RiskUrlVersionPO{" +
                "id='" + id + '\'' +
                ", protocol='" + protocol + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", version='" + version + '\'' +
                ", token='" + token + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id == null ? "" :id;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol == null ? "" : protocol.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? "" : ip.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? "" : port.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? "" : version.trim();
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
