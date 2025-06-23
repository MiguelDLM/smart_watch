package com.fd.aliiot.core.entity;

/* loaded from: classes8.dex */
public class WearCommonCommand {
    private String cmdIdentifier;
    private int code;
    private String data;
    private String message;
    private String trackId;

    public String getCmdIdentifier() {
        return this.cmdIdentifier;
    }

    public int getCode() {
        return this.code;
    }

    public String getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTrackId() {
        return this.trackId;
    }

    public void setCmdIdentifier(String str) {
        this.cmdIdentifier = str;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setTrackId(String str) {
        this.trackId = str;
    }
}
