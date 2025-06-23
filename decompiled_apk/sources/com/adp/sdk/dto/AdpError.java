package com.adp.sdk.dto;

/* loaded from: classes.dex */
public class AdpError {
    private String code;
    private String message;

    public AdpError() {
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public AdpError(String str, String str2) {
        this.code = str;
        this.message = str2;
    }
}
