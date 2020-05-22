package com.enumerate;

/**
 * @description: AuthCode
 * @date: 2020/5/22 15:47
 * @author: Finallap
 * @version: 1.0
 */

public enum AuthCode {
    Allow("00000", "00000", "允许访问"),
    AU0001("100001", "AU0001", "新增用户"),
    AU0002("100002", "AU0002", "删除用户");

    private String authId;
    private String authCode;
    private String authName;

    AuthCode(String authId, String authCode, String authName) {
        this.authId = authId;
        this.authCode = authCode;
        this.authName = authName;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    @Override
    public String toString() {
        return "AuthCode{" +
                "authId='" + authId + '\'' +
                ", authCode='" + authCode + '\'' +
                ", authName='" + authName + '\'' +
                '}';
    }
}