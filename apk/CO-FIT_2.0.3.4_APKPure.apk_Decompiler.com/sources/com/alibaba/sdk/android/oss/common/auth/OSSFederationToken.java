package com.alibaba.sdk.android.oss.common.auth;

import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.sma.smartv3.util.xoIox;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class OSSFederationToken {
    private long expiration;
    private String securityToken;
    private String tempAk;
    private String tempSk;

    public OSSFederationToken(String str, String str2, String str3, long j) {
        setTempAk(str);
        setTempSk(str2);
        setSecurityToken(str3);
        setExpiration(j);
    }

    public long getExpiration() {
        return this.expiration;
    }

    public String getSecurityToken() {
        return this.securityToken;
    }

    public String getTempAK() {
        return this.tempAk;
    }

    public String getTempSK() {
        return this.tempSk;
    }

    public void setExpiration(long j) {
        this.expiration = j;
    }

    public void setExpirationInGMTFormat(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(xoIox.f10993oo);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            this.expiration = simpleDateFormat.parse(str).getTime() / 1000;
        } catch (ParseException e) {
            if (OSSLog.isEnableLog()) {
                e.printStackTrace();
            }
            this.expiration = (DateUtil.getFixedSkewedTimeMillis() / 1000) + 30;
        }
    }

    public void setSecurityToken(String str) {
        this.securityToken = str;
    }

    public void setTempAk(String str) {
        this.tempAk = str;
    }

    public void setTempSk(String str) {
        this.tempSk = str;
    }

    public String toString() {
        return "OSSFederationToken [tempAk=" + this.tempAk + ", tempSk=" + this.tempSk + ", securityToken=" + this.securityToken + ", expiration=" + this.expiration + "]";
    }

    public OSSFederationToken(String str, String str2, String str3, String str4) {
        setTempAk(str);
        setTempSk(str2);
        setSecurityToken(str3);
        setExpirationInGMTFormat(str4);
    }
}
